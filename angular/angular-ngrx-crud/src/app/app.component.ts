import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';

import AppState from './models/app-state.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  title = 'ngrx-app';
  // tslint:disable-next-line:ban-types
  loading$: Observable<Boolean>;

  constructor(private store: Store<AppState>) {
  }

  ngOnInit(): void {
    this.loading$ = this.store.select(store => store.post.loading);
  }

}
