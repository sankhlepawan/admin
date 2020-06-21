import { Component, OnInit, Input } from '@angular/core';
import { MediaObserver } from '@angular/flex-layout';
import { Router } from '@angular/router';
import { BioModel } from '../../bio.types';
import { BioService } from '../../bio.service';


@Component({
    selector: 'app-user-profile',
    templateUrl: './user-profile.component.html',
    styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
    constructor(private media: MediaObserver, private router: Router,private _service: BioService) { }

    ngOnInit(): void { }

    @Input() bio: any;

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

    onBioEdit(bio: BioModel) {
        this._service.setSelectedBio(bio);
        this.router.navigate(['bio/add-bio', { isEdit: true }], { skipLocationChange: true });
      }
}
