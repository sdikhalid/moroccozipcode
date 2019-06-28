(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./$$_lazy_route_resource lazy recursive":
/*!******************************************************!*\
  !*** ./$$_lazy_route_resource lazy namespace object ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/app.component.html":
/*!**************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/app.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n \n<form class=\"postal-form\" [formGroup]='codesForm'>\n  <mat-form-field >\n    <input placeholder=\"Choisissez une ville quartier ou avenue...\" matInput   [matAutocomplete]=\"auto\" formControlName='userInput'>\n  </mat-form-field>\n  <mat-autocomplete  #auto=\"matAutocomplete\" [displayWith]=\"displayFn\">\n    <mat-option *ngIf=\"isLoading\" class=\"is-loading\"><mat-spinner diameter=\"50\"></mat-spinner></mat-option>\n    <ng-container *ngIf=\"!isLoading\">\n      <mat-option (onSelectionChange)=\"selectPostalCode(postalcode)\" *ngFor=\"let postalcode of filteredCodes\" [value]=\"postalcode\">\n        <span>{{ postalcode.city }}</span>\n        <small> | {{postalcode.place}}</small>\n      </mat-option>\n    </ng-container>\n  </mat-autocomplete>\n\n  <div class=\"postalcode\" *ngIf=\"selectedCode\" >  {{ selectedCode.code }} </div>\n</form>\n\n"

/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n.input {\r\n\twidth: 500px;\r\n\theight: 100px;\r\n\r\n\r\n\tposition: absolute;\r\n\ttop:0;\r\n\tbottom: 0;\r\n\tleft: 0;\r\n\tright: 0;\r\n\t\r\n\tmargin: auto;\r\n}\r\n\r\n.postalcode {\r\n\tmargin-top: 9px;\r\n\tborder: 1px solid;\r\n\ttext-align: center;\r\n\tborder-right-color: rgba(58,42,42,1);\r\n\tborder-radius: 5px;\r\n\tcolor: black;\r\n\ttext-overflow: ellipsis;\r\n\tvertical-align:midlle;\r\n\twidth: 100%;\r\n\tfont-weight: bold;\r\n\talign-items: center\r\n  }\r\n\r\n.postal-form {\r\n\tmin-width: 300px;\r\n\tmax-width: 500px;\r\n\twidth: 100%;\r\n  }\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtBQUNBO0NBQ0MsWUFBWTtDQUNaLGFBQWE7OztDQUdiLGtCQUFrQjtDQUNsQixLQUFLO0NBQ0wsU0FBUztDQUNULE9BQU87Q0FDUCxRQUFROztDQUVSLFlBQVk7QUFDYjs7QUFFQTtDQUNDLGVBQWU7Q0FDZixpQkFBaUI7Q0FDakIsa0JBQWtCO0NBQ2xCLG9DQUFvQztDQUVwQyxrQkFBa0I7Q0FDbEIsWUFBWTtDQUNaLHVCQUF1QjtDQUN2QixxQkFBcUI7Q0FDckIsV0FBVztDQUNYLGlCQUFpQjtDQUNqQjtFQUNDOztBQUVBO0NBQ0QsZ0JBQWdCO0NBQ2hCLGdCQUFnQjtDQUNoQixXQUFXO0VBQ1YiLCJmaWxlIjoic3JjL2FwcC9hcHAuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG4uaW5wdXQge1xyXG5cdHdpZHRoOiA1MDBweDtcclxuXHRoZWlnaHQ6IDEwMHB4O1xyXG5cclxuXHJcblx0cG9zaXRpb246IGFic29sdXRlO1xyXG5cdHRvcDowO1xyXG5cdGJvdHRvbTogMDtcclxuXHRsZWZ0OiAwO1xyXG5cdHJpZ2h0OiAwO1xyXG5cdFxyXG5cdG1hcmdpbjogYXV0bztcclxufVxyXG5cclxuLnBvc3RhbGNvZGUge1xyXG5cdG1hcmdpbi10b3A6IDlweDtcclxuXHRib3JkZXI6IDFweCBzb2xpZDtcclxuXHR0ZXh0LWFsaWduOiBjZW50ZXI7XHJcblx0Ym9yZGVyLXJpZ2h0LWNvbG9yOiByZ2JhKDU4LDQyLDQyLDEpO1xyXG5cdC13ZWJraXQtYm9yZGVyLXJhZGl1czogNXB4O1xyXG5cdGJvcmRlci1yYWRpdXM6IDVweDtcclxuXHRjb2xvcjogYmxhY2s7XHJcblx0dGV4dC1vdmVyZmxvdzogZWxsaXBzaXM7XHJcblx0dmVydGljYWwtYWxpZ246bWlkbGxlO1xyXG5cdHdpZHRoOiAxMDAlO1xyXG5cdGZvbnQtd2VpZ2h0OiBib2xkO1xyXG5cdGFsaWduLWl0ZW1zOiBjZW50ZXJcclxuICB9XHJcbiAgXHJcbiAgLnBvc3RhbC1mb3JtIHtcclxuXHRtaW4td2lkdGg6IDMwMHB4O1xyXG5cdG1heC13aWR0aDogNTAwcHg7XHJcblx0d2lkdGg6IDEwMCU7XHJcbiAgfVxyXG4iXX0= */"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _app_services__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./app.services */ "./src/app/app.services.ts");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm2015/operators/index.js");





let AppComponent = class AppComponent {
    constructor(fb, postalCodeService) {
        this.fb = fb;
        this.postalCodeService = postalCodeService;
        this.title = 'Morocco Zip Code';
        this.filteredCodes = [];
        this.isLoading = false;
    }
    ngOnInit() {
        this.codesForm = this.fb.group({
            userInput: null
        });
        this.codesForm
            .get('userInput')
            .valueChanges
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["debounceTime"])(300), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["distinctUntilChanged"])(), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["tap"])(() => this.isLoading = true))
            .subscribe(value => this.postalCodeService.find(value).subscribe(results => {
            this.filteredCodes = results;
            this.isLoading = false;
        }));
    }
    displayFn(postalcode) {
        if (postalcode) {
            return postalcode.place;
        }
    }
    selectPostalCode(postalcode) {
        this.selectedCode = postalcode;
    }
};
AppComponent.ctorParameters = () => [
    { type: _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormBuilder"] },
    { type: _app_services__WEBPACK_IMPORTED_MODULE_1__["PostalCodeService"] }
];
AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Component"])({
        selector: 'app-root',
        template: __webpack_require__(/*! raw-loader!./app.component.html */ "./node_modules/raw-loader/index.js!./src/app/app.component.html"),
        styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
    })
], AppComponent);



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm2015/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_material_autocomplete__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material/autocomplete */ "./node_modules/@angular/material/esm2015/autocomplete.js");
/* harmony import */ var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/material/form-field */ "./node_modules/@angular/material/esm2015/form-field.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm2015/animations.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm2015/material.js");
/* harmony import */ var _app_services__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./app.services */ "./src/app/app.services.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");












let AppModule = class AppModule {
};
AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
        declarations: [
            _app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"]
        ],
        imports: [
            _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
            _angular_material_autocomplete__WEBPACK_IMPORTED_MODULE_3__["MatAutocompleteModule"],
            _angular_material_form_field__WEBPACK_IMPORTED_MODULE_4__["MatFormFieldModule"],
            _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_6__["BrowserAnimationsModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_7__["ReactiveFormsModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_7__["FormsModule"],
            _angular_material__WEBPACK_IMPORTED_MODULE_8__["MatInputModule"],
            _angular_material__WEBPACK_IMPORTED_MODULE_8__["MatProgressSpinnerModule"],
            _angular_common_http__WEBPACK_IMPORTED_MODULE_10__["HttpClientModule"]
        ],
        providers: [_app_services__WEBPACK_IMPORTED_MODULE_9__["PostalCodeService"]],
        bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"]]
    })
], AppModule);



/***/ }),

/***/ "./src/app/app.services.ts":
/*!*********************************!*\
  !*** ./src/app/app.services.ts ***!
  \*********************************/
/*! exports provided: PostalCodeService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PostalCodeService", function() { return PostalCodeService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");



let PostalCodeService = class PostalCodeService {
    constructor(httpClient) {
        this.httpClient = httpClient;
        this.apiV1URL = '/api/postalcode/v1/';
    }
    find(value) {
        return this.httpClient.get(this.apiV1URL + value);
    }
};
PostalCodeService.ctorParameters = () => [
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] }
];
PostalCodeService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])()
], PostalCodeService);



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
const environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var hammerjs__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! hammerjs */ "./node_modules/hammerjs/hammer.js");
/* harmony import */ var hammerjs__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(hammerjs__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm2015/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");





if (_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_2__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_3__["AppModule"])
    .catch(err => console.error(err));


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! D:\repos\postalcode\ma.postalcode-client\src\main\web\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main-es2015.js.map