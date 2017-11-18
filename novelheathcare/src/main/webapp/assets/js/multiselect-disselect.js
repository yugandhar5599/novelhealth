$("#checkAll").click(function () {
    $(".check").prop('checked', $(this).prop('checked'));
});

//if all checkbox are selected, check the selectall checkbox
// and viceversa
$(".check").click(function(){

	if($(".check").length === $(".check:checked").length) {
		$("#checkAll").prop("checked", "checked");
	} else {
		$("#checkAll").prop("checked","");
	}

});

$("#DeleteButton").click(function(e){
	 e.preventDefault();
	 $('form[name=table-form]').append("<input type='hidden' name='action' value='delete'/>");
	 $('form[name=table-form]').attr('action','./multipleDelete');
	$('form[name=table-form]').submit(); 
	
});