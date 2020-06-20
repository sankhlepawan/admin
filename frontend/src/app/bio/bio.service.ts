import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BioModel, AllBioApi } from './bio.types';
import { Logger } from '@core/logger.service';
import { defaultPagination } from '@shared/constants';
const log = new Logger('CollectionService');

@Injectable({
  providedIn: 'root',
})
export class BioService {
  constructor(private _httpClient: HttpClient) {}

  search(sort: string, order: string, page: number, size: number, q: string): Observable<AllBioApi> {
    log.info('fetching order data...');
    const body = { ...defaultPagination, q: q, page: page, limit: size };
    const url = '/v1/bio/search';
    return this._httpClient.post<AllBioApi>(url, body);
  }

  addBio(body: BioModel) {
    const url = '/v1/bio/create';
    return this._httpClient.post<BioModel>(url, body);
  }
}
