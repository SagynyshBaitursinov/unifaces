var enter = false;

$(document).keypress(function(e) {
    if (e.keyCode == 13 && enter) {
        e.preventDefault();
        next();
    }
});

$(document).ready(function() {
	$('#myModal').modal({
	    backdrop: 'static',
	    keyboard: false
	});
	$('#myModal').modal('hide');
	checkColor();
	$("#points").click(function() {
		window.location.href = topurl;
	});
	$(".list-group-item").click(function() {
		$.ajax({
			  url: checkurl + "?questionId=" + this.parentElement.id + "&answer=" + this.id
			}).done(function(data, textStatus, xhr) {
			    try {
			    	var obj = jQuery.parseJSON(data);
			    } catch(e) {
					window.location.href = "/unifaces";
			    }
				if (obj.correct == "true") {
					$("#modal-title").html("<b>Right +30</b>");
					$("#points").html(parseInt($("#points").html()) + 30);
					$("#modal-title").removeClass("red").addClass("green");
				} else {
					$("#modal-title").html("<b>Wrong</b>");
					$("#modal-title").removeClass("green").addClass("red");
				}
				$('#modal-body').html(obj.info);
				$('#myModal').modal('show');
				enter = true;
			});
	});
});

function next() {
	$('#myModal').modal('hide');
	enter = false;
	$.ajax({
		  url: nexturl
		}).done(function(data, textStatus, xhr) {
			try {
				var obj = jQuery.parseJSON(data);
			} catch (e) {
				window.location.href = "/unifaces";
			}
			$("#ava").attr("src", photourl + "?questionId=" + obj.id);
			$("ul").toArray()[0].id = obj.id;
			$("li").toArray()[0].id = obj.id1;
			$("li").toArray()[1].id = obj.id2;
			$("li").toArray()[2].id = obj.id3;
			$("li").toArray()[3].id = obj.id4;
			$("li").toArray()[0].innerHTML = obj.name1;
			$("li").toArray()[1].innerHTML = obj.name2;
			$("li").toArray()[2].innerHTML = obj.name3;
			$("li").toArray()[3].innerHTML = obj.name4;
		});
		$("#points").html(parseInt($("#points").html()) - 10);
}

function checkColor() {
	var a = $("#points").html();
	if (a < 0) {
		$("#points").removeClass("green").addClass("red")
	} else if (a > 0) {
		$("#points").removeClass("red").addClass("green");
	} else {
		$("#points").removeClass("red").removeClass("green");
	}
}