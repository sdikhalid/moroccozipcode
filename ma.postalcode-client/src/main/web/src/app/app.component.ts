import {PostalCodeService} from "./app.services"
import {Component, OnInit} from '@angular/core';
import {PostalCode} from './postalcode.class';
import {FormBuilder, FormGroup} from '@angular/forms';
import {switchMap, debounceTime, tap, finalize, distinctUntilChanged} from 'rxjs/operators';
import {Observable} from 'rxjs'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'Morocco Zip Code';
  filteredCodes: PostalCode[] = [];
  codesForm: FormGroup;
  isLoading = false;
  selectedCode;

  constructor(private fb: FormBuilder, private  postalCodeService: PostalCodeService) {
  }

  ngOnInit() {
    this.codesForm = this.fb.group({
      userInput: null
    })
    this.codesForm
      .get('userInput')
      .valueChanges
      .pipe(
        debounceTime(300),
        distinctUntilChanged(),
        tap(() => this.isLoading = true),
      )
      .subscribe(value =>
        this.postalCodeService.find(value).subscribe(
          results => {
            this.filteredCodes = results;
            this.isLoading = false;
          }
        ));
  }

  displayFn(postalcode: PostalCode) {
    if (postalcode) {
      return postalcode.place;
    }
  }

  selectPostalCode(postalcode: PostalCode) {
    this.selectedCode = postalcode;
  }

}
