var LaudoController = new function() {
	
	this.list = function() {
		$('#laudosTableBody').empty();
		
		$.get( "/laudos", function( data ) {
			$.each(data, function(i, item) {
		        $('<tr>').append(
		            $('<td>').text(item.idLaudo),
					$('<td>').text(item.texto),
					$('<td>').text(item.atendimento),
					$('<td class="actions"><a class="btn btn-warning btn-xs" onclick="LaudoController.edit('+item.idLaudo+')">Editar</a><a class="btn btn-danger btn-xs" onclick="LaudoController.delete('+item.idLaudo+')">Excluir</a></td>')
		        ).appendTo('#laudosTableBody');
		    });
		});
	}
	
	this.delete = function(idLaudo) {
		$.ajax({
		    url: '/laudos/'+idLaudo,
		    method: 'DELETE',
		    contentType: 'application/json',
		    success: function(result) {
		        LaudoController.list();
		    },
		    error: function(request,msg,error) {
		        alert('erro ao deletar');
		    }
		});
	}
	
	this.save = function() {
		var idLaudoToEdit = $("#laudoId").val();
		
		if (idLaudoToEdit == null || idLaudoToEdit == "") {
			var laudo = this.getDadosLaudoModal();
			
			$.ajax({
			    url: '/laudos',
			    type: 'POST',
			    contentType: "application/json; charset=utf-8",
	    		dataType: "json",
				data: JSON.stringify(laudo),
			    success: function() {
			        $("#laudoId").val("");
					$('#cadastrarLaudo').modal('hide');
					LaudoController.list();
					LaudoController.limparDadosLaudoModal();
			    },
			    error: function(request,msg,error) {
			       $("#laudoId").val("");
					$('#cadastrarLaudo').modal('hide');
					LaudoController.list();
					LaudoController.limparDadosLaudoModal();
			    }
			});
		}
		else {
			LaudoController.update(idLaudoToEdit);
		}
		
	}
	
	this.update = function(idLaudo) {
		var laudo = this.getDadosLaudoModal();
		
		$.ajax({
		    url: '/laudos/'+idLaudo,
		    method: 'PUT',
		    contentType: "application/json; charset=utf-8",
    		dataType: "json",
			data: JSON.stringify(laudo),
		    success: function(result) {
		        $("#laudoId").val("");
				$('#cadastrarLaudo').modal('hide');
				LaudoController.list();
				LaudoController.limparDadosLaudoModal();
		    },
		    error: function(request,msg,error) {
		       $("#laudoId").val("");
			   $('#cadastrarLaudo').modal('hide');
			   LaudoController.list();
			   LaudoController.limparDadosLaudoModal();
		    }
		});
	}
	
	this.edit = function(idLaudo) {
		$("#laudoId").val(idLaudo);
		
		$.get( "/laudos/" + idLaudo, function( data ) {
			$('#cadastrarLaudo').modal('show');
			LaudoController.setDadosLaudoModal(data);
		});
	}
	
	this.setDadosLaudoModal = function(laudo) {
		$('#laudoTexto').val(laudo.texto),
		$('#laudoAtendimento').val(laudo.atendimento)
	}
	
	this.limparDadosLaudoModal = function() {
		$('#laudoTexto').val(''),
		$('#atendimentoSelectList').val('')
	}
		
	this.getDadosLaudoModal = function() {
		var laudo = {
			texto: $('#laudoTexto').val(),
			atendimento: {
				id atendimento: $('#atendimentoSelectList').val()
			}
		}
		
		return laudo;
	}
	
}
