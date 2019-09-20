$(document).ready(function(){
    $('#matches').DataTable();
});
$('#scoresModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var par1 = button.data('participant1-name') // Extract info from data-* attributes
  var par2 = button.data('participant2-name')
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  var modal = $(this)
  modal.find('#participant1Name').text(par1)
  modal.find('#participant2Name').text(par2)
})