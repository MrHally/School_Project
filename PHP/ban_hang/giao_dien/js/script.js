$(document).ready(function(){
    $('.navbar .search-form').hide();
    $('.navbar .search-toggle').click(function(){
      $('.navbar .search-form').toggle();
      $('.navbar .search-form input[type="search"]').focus();
    });
  });