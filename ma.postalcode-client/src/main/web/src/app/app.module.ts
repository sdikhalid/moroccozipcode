import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatFormFieldModule} from '@angular/material/form-field';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material';
import {MatProgressSpinnerModule} from '@angular/material';
import {PostalCodeService} from "./app.services"
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    MatAutocompleteModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    MatInputModule,
    MatProgressSpinnerModule,
    HttpClientModule
  ],
  providers: [PostalCodeService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
