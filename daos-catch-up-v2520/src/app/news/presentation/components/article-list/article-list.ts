import {Component, input, InputSignal} from '@angular/core';
import {ArticleItem} from '../article-item/article-item';
import {Article} from '../../../domain/model/article.entity';

@Component({
  selector: 'app-article-list',
  imports: [ArticleItem],
  templateUrl: './article-list.html',
  styleUrl: './article-list.css'
})
export class ArticleList {
  articles: InputSignal<Article[]> = input.required<Array<Article>>();
}
