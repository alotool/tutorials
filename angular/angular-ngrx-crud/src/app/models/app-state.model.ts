import {PostState} from '../store/reducers/posts.reducer';

export default interface AppState {
  post: PostState;
}


// StoreModule.forRoot({
//     post: PostsReducer
//   }, {}),
