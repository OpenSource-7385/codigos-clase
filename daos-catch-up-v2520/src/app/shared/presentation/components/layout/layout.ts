import {Component, inject, OnInit, Signal} from '@angular/core';
import {NewsStore} from '../../../../news/application/news-store';
import {Source} from '../../../../news/domain/model/source.entity';
import {MatSidenav, MatSidenavContainer, MatSidenavContent} from '@angular/material/sidenav';
import {MatToolbar} from '@angular/material/toolbar';
import {SourceList} from '../../../../news/presentation/components/source-list/source-list';
import {MatIcon} from '@angular/material/icon';
import {LanguageSwitcher} from '../language-switcher/language-switcher';
import {ArticleList} from '../../../../news/presentation/components/article-list/article-list';
import {Footer} from '../footer/footer';
import {MatIconButton} from '@angular/material/button';
import {Article} from '../../../../news/domain/model/article.entity';

@Component({
  selector: 'app-layout',
  imports: [MatSidenavContainer, MatToolbar, MatSidenav, SourceList, MatSidenavContent, MatIcon,
    LanguageSwitcher, ArticleList, Footer, MatIconButton],
  templateUrl: './layout.html',
  styleUrl: './layout.css'
})
export class Layout implements OnInit {
  protected store = inject(NewsStore);
  protected readonly sources: Signal<Source[]> = this.store.sources;
  protected readonly articles: Signal<Article[]> = this.store.currentSourceArticles;

  ngOnInit(): void {
    this.store.loadSources();
  }

  updateArticlesBySource(source: Source): void {
    this.store.currentSource = source;
    this.store.loadArticlesForCurrentSource();
  }
}
