import { Component, OnInit, Input } from '@angular/core';
import { MediaObserver } from '@angular/flex-layout';
import { Router } from '@angular/router';
import { BioModel } from '../../bio.types';
import { BioService } from '../../bio.service';
import { ActivatedRoute } from '@angular/router';


@Component({
    selector: 'app-user-profile-detail',
    templateUrl: './user-profile-detail.component.html',
    styleUrls: ['./user-profile-detail.component.scss']
})
export class UserProfileDetailComponent implements OnInit {
    
    bio: BioModel;
    isEdit = false;
    constructor(
        private media: MediaObserver,
        private router: Router,
        private _service: BioService,
        private route: ActivatedRoute
        ) { }

    getUploadUrl(bioId: number) {
        return '/v1/bio/uploadProfilePic/' + bioId;
    }

    ngOnInit(): void {
        this.isEdit = this.route.snapshot.paramMap.get('isEdit') == "true";
        this.bio = this._service.getSelectedBio();

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

    onBioEdit(bio: BioModel) {
        this._service.setSelectedBio(bio);
        this.router.navigate(['bio/add-bio', { isEdit: true }], { skipLocationChange: true });
      }
}
