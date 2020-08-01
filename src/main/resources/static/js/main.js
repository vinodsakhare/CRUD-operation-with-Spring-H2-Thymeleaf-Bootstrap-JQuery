 $(document).ready(function() {
 		$('.table .editButton').on('click',function(event){
 		event.preventDefault();
 		
 		var href=$(this).attr('href');
 		
 		$.get(href,function(nationality, status){
 		  $('#IdEdit').val(nationality.id);
 		  $('#nameEdit').val(nationality.name);
 		  $('#capitalEdit').val(nationality.capital);
 		  $('#updatedByEdit').val(nationality.updatedBy);
 		  $('#updatedOnEdit').val(nationality.updatedOn.substr(0,10));
 		  
 		});
 		
 		 $('#editModal').modal();
 		});
 		
 		$('.table .deleteButton').on('click',function(event){
 		event.preventDefault();
 		
 		var href=$(this).attr('href');
 		
 		 $('#deleteModal #deleteId').attr('href',href)
 		 $('#deleteModal').modal();
 		});
 		
 });