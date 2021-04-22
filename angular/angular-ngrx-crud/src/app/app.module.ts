import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {StoreModule} from '@ngrx/store';
import {HttpClientModule} from '@angular/common/http';
import {StoreDevtoolsModule} from '@ngrx/store-devtools';
import {environment} from '../environments/environment';
import {EffectsModule} from '@ngrx/effects';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PostsComponent} from './components/posts/posts/posts.component';
import {PostsReducer} from './store/reducers/posts.reducer';
import {AddPostComponent} from './components/posts/add-post/add-post.component';
import {DeletePostComponent} from './components/posts/delete-post/delete-post.component';
import {PostEffects} from './store/effects/post.effects';


@NgModule({
  declarations: [
    AppComponent,
    PostsComponent,
    AddPostComponent,
    DeletePostComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    StoreModule.forRoot({post: PostsReducer}, {}),
    StoreDevtoolsModule.instrument({maxAge: 25, logOnly: environment.production}),
    EffectsModule.forRoot([
      PostEffects
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
