import { Component, OnInit, Input } from '@angular/core';

@Component({
    selector: 'app-user-profile',
    templateUrl: './user-profile.component.html',
    styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
    constructor() { }

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
}
