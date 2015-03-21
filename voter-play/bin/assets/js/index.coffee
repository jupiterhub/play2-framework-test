$ ->
   $.get "/topics", (topics) ->
      $.each topics, (index, topic) ->
         $('#topics').append $("<li>").text topic.title