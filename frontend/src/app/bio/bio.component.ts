import { MediaObserver } from '@angular/flex-layout';
import { BioService } from './bio.service';
import { BioModel, AllBioApi } from './bio.types';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { CollectionViewer, DataSource } from '@angular/cdk/collections';
import { ChangeDetectionStrategy, Component, ViewChild, AfterViewInit } from '@angular/core';
import { BehaviorSubject, Observable, Subscription } from 'rxjs';

@Component({
  selector: 'app-bio',
  templateUrl: './bio.component.html',
  styleUrls: ['./bio.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class BioComponent implements AfterViewInit {
  data: any;
  ds: any;

  constructor(private _service: BioService, private media: MediaObserver) {}

  _getData() {
    this.ds = new MyDataSource(this._service);
  }

  ngAfterViewInit() {
    this._getData();
  }

  getUploadUrl(bioId: number) {
    return '/v1/bio/uploadProfilePic/' + bioId;
  }

  onFileComplete(event: any, bio: any) {
    console.log('event==>', event);
    if (event) {
      bio.profilePic = event.path;
    }
  }

  get isMobile(): boolean {
    return this.media.isActive('xs') || this.media.isActive('sm');
  }
}

export class MyDataSource extends DataSource<BioModel | undefined> {
  private _length = 0;
  private _cachedData = Array.from<BioModel>({ length: this._length });
  private _dataStream = new BehaviorSubject<(BioModel | undefined)[]>(this._cachedData);
  private _subscription = new Subscription();
  private pageSize = 4;
  private lastPage = 0;

  constructor(private _service: BioService) {
    super();
    this._fetchFactPage();
  }

  connect(
    collectionViewer: CollectionViewer
  ): Observable<(BioModel | undefined)[] | ReadonlyArray<BioModel | undefined>> {
    this._subscription.add(
      collectionViewer.viewChange.subscribe((range) => {
        const currentPage = this._getPageForIndex(range.end);
        console.log(currentPage, this.lastPage);
        if (currentPage > this.lastPage) {
          this.lastPage = currentPage;
          this._fetchFactPage();
        }
      })
    );
    return this._dataStream;
  }

  private _fetchFactPage(): void {
    //for (let i = 0; i < 2; ++i) {
    this._service.search('id', 'desc', this.lastPage, this.pageSize, '').subscribe((res: AllBioApi) => {
      console.log(this._cachedData);
      this._cachedData = this._cachedData.concat(res.items);
      console.log(this._cachedData);
      this._dataStream.next(this._cachedData);
    });

    // }
  }

  private _getPageForIndex(i: number): number {
    return Math.floor(i / this.pageSize);
  }

  disconnect(): void {
    this._subscription.unsubscribe();
  }
}