import {Component, input, InputSignal, output, OutputEmitterRef} from '@angular/core';
import {MatListItem} from '@angular/material/list';
import {Source} from '../../../domain/model/source.entity';

@Component({
  selector: 'app-source-item',
  imports: [MatListItem],
  templateUrl: './source-item.html',
  styleUrl: './source-item.css'
})
export class SourceItem {
  source: InputSignal<Source> = input.required<Source>();
  sourceSelected: OutputEmitterRef<Source> = output<Source>();

  emitSourceSelectedEvent() {
    this.sourceSelected.emit(this.source());
  }
}
