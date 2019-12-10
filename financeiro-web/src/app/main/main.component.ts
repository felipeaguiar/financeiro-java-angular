import { Component, OnInit } from '@angular/core';
import { ThemeService } from '../core/theme.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  constructor(
    private themeService: ThemeService
  ) { }

  ngOnInit() {
    this.themeService.initMain();
  }

}
