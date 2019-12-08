import { Component, OnInit } from '@angular/core';

declare const $: any;

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $(() => {
      $(() => {
        $('.preloader').fadeOut();
      });
      $(document).on('click', '.mega-dropdown', (e) => {
        e.stopPropagation();
      });
      // ==============================================================
      // This is for the top header part and sidebar part
      // ==============================================================
      var set = function() {
        var width = (window.innerWidth > 0) ? window.innerWidth : this.screen.width;
        var topOffset = 0;
        if (width < 1170) {
          $('body').addClass('mini-sidebar');
          $('.navbar-brand span').hide();
          $('.sidebartoggler i').addClass('ti-menu');
        } else {
          $('body').removeClass('mini-sidebar');
          $('.navbar-brand span').show();
        }

        var height = ((window.innerHeight > 0) ? window.innerHeight : this.screen.height) - 1;
        height = height - topOffset;

        if (height < 1) {
          height = 1;
        }

        if (height > topOffset) {
          $('.page-wrapper').css('min-height', (height) + 'px');
        }

      };
      $(window).ready(set);
      $(window).on('resize', set);

      // ==============================================================
      // Theme options
      // ==============================================================
      $('.sidebartoggler').on('click', () => {
        if ($('body').hasClass('mini-sidebar')) {
          $('body').trigger('resize');
          $('body').removeClass('mini-sidebar');
          $('.navbar-brand span').show();

        } else {
          $('body').trigger('resize');
          $('body').addClass('mini-sidebar');
          $('.navbar-brand span').hide();

        }
      });

      // this is for close icon when navigation open in mobile view
      $('.nav-toggler').click(() => {
        $('body').toggleClass('show-sidebar');
        $('.nav-toggler i').toggleClass('ti-menu');
        $('.nav-toggler i').addClass('ti-close');
      });

      $('.search-box a, .search-box .app-search .srh-btn').on('click', () => {
        $('.app-search').toggle(200);
      });
      // ==============================================================
      // This is for the floating labels
      // ==============================================================
      $('.floating-labels .form-control').on('focus blur', function(e) {
        $(this).parents('.form-group').toggleClass('focused', (e.type === 'focus' || this.value.length > 0));
      }).trigger('blur');

      // ==============================================================
      // Auto select left navbar
      // ==============================================================
      $(function() {
        var url = window.location;
        var element = $('ul#sidebarnav a').filter(() => {
          return this.href === url;
        }).addClass('active').parent().addClass('active');
        while (true) {
          if (element.is('li')) {
            element = element.parent().addClass('in').parent().addClass('active');
          } else {
            break;
          }
        }

      });
      // ==============================================================
      // tooltip
      // ==============================================================
      $(() => {
        $('[data-toggle="tooltip"]').tooltip();
      });
      // ==============================================================
      // Popover
      // ==============================================================
      $(() => {
        $('[data-toggle="popover"]').popover();
      });
      // ==============================================================
      // Sidebarmenu
      // ==============================================================
      $(() => {
        $('#sidebarnav').AdminMenu();
      });

      // ==============================================================
      // Perfact scrollbar
      // ==============================================================
      $('.scroll-sidebar, .right-side-panel, .message-center').perfectScrollbar();

      // ==============================================================
      // Resize all elements
      // ==============================================================
      $('body').trigger('resize');
      // ==============================================================
      // To do list
      // ==============================================================
      $('.list-task li label').click(() => {
        $(this).toggleClass('task-done');
      });



      // ==============================================================
      // Collapsable cards
      // ==============================================================
      $('a[data-action="collapse"]').on('click', (e) => {
        e.preventDefault();
        $(this).closest('.card').find('[data-action="collapse"] i').toggleClass('ti-minus ti-plus');
        $(this).closest('.card').children('.card-body').collapse('toggle');

      });
      // Toggle fullscreen
      $('a[data-action="expand"]').on('click', (e) => {
        e.preventDefault();
        $(this).closest('.card').find('[data-action="expand"] i').toggleClass('mdi-arrow-expand mdi-arrow-compress');
        $(this).closest('.card').toggleClass('card-fullscreen');
      });

      // Close Card
      $('a[data-action="close"]').on('click', () => {
        $(this).closest('.card').removeClass().slideUp('fast');
      });

    });
  }

}
