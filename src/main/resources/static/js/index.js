$(document).ready(function(){
    $('#matches').DataTable( {
    "columnDefs": [
        { "orderable": false, "targets": 4 }
    ]
    });
});
$('#scoresModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var matchId = button.data('match-id') // Extract info from data-* attributes
  var matchToSaveTournamentId = button.data('match-tournament-id')
  var par1 = button.data('participant1-name') // Extract info from data-* attributes
  var par2 = button.data('participant2-name')
  var par1ID = button.data('participant1-id') // Extract info from data-* attributes
  var par2ID = button.data('participant2-id')
  var modal = $(this)
  modal.find('#matchToSaveTournamentId').val(matchToSaveTournamentId)
  modal.find('#participant1Name').text(par1)
  modal.find('#participant2Name').text(par2)
  modal.find('#matchToSaveId').val(matchId)
  modal.find('#matchToSaveParticipant1Id').val(par1ID)
  modal.find('#matchToSaveParticipant2Id').val(par2ID)
});
$('#scoresModal').on('hidden.bs.modal', function(){
    var modal = $(this)
    modal.find('#participant1Score').val(0)
    modal.find('#participant2Score').val(0)
});
function pronify() {
    document.getElementById("hub").removeAttribute("style");
    document.getElementById("hub").style.backgroundColor="#f8981d";
}