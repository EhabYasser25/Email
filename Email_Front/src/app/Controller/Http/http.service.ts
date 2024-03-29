import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private _url: string = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  deleteRequest(instruction: string): Observable<any> {
    return this.http.delete(`${this._url}${instruction}`);
  }

  postRequest(instruction: string, requestBody?: any): Observable<any> {
    return this.http.post(`${this._url}${instruction}`, requestBody, {responseType: 'text'});
  }

  getRequest(instruction: string, requestBody?: any): Observable<any> {
    return this.http.get(`${this._url}${instruction}`, {params: {requestBody}, responseType: 'text'});
  }

  download(name: string): Observable<HttpEvent<Blob>> {
    return this.http.get(`${this._url}Attachments/download/${name}`,{
      reportProgress: true,
      observe: 'events',
      responseType: 'blob'
    }); 
  }

  putRequest(instruction: string, requestBody?: any): Observable<any> {
    return this.http.put(`${this._url}${instruction}`, requestBody, {responseType: 'text'});
  }

}