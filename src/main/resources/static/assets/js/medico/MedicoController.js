var MedicoController = new function() {
	
	this.list = function() {
		$('#medicosTableBody').empty();
		
		$.get( "/medicos", function( data ) {
			$.each(data, function(i, item) {
		        $('<tr>').append(
		            $('<td>').text(item.idMedico),
		            $('<td>').text(item.nome),
					$('<td>').text(item.crm),
					$('<td class="actions"><a class="btn btn-warning btn-xs" onclick="MedicoController.edit('+item.idMedico+')">Editar</a><a class="btn btn-danger btn-xs" onclick="MedicoController.delete('+item.idMedico+')">Excluir</a></td>')
		        ).appendTo('#medicosTableBody');
		    });
		});
	}
	
	this.delete = function(idMedico) {
		$.ajax({
		    url: '/medicos/'+idMedico,
		    method: 'DELETE',
		    contentType: 'application/json',
		    success: function(result) {
		        MedicoController.list();
		    },
		    error: function(request,msg,error) {
		        alert('erro ao deletar');
		    }
		});
	}
	
	this.save = function() {
		var idMedicoToEdit = $("#medicoId").val();
		
		if (idMedicoToEdit == null || idMedicoToEdit == "") {
			var medico = this.getDadosMedicoModal();
			
			$.ajax({
			    url: '/medicos',
			    type: 'POST',
			    contentType: "application/json; charset=utf-8",
	    		dataType: "json",
				data: JSON.stringify(medico),
			    success: function() {
			        $("#medicoId").val("");
					$('#cadastrarMedico').modal('hide');
					MedicoController.list();
					MedicoController.limparDadosMedicoModal();
			    },
			    error: function(request,msg,error) {
			       $("#medicoId").val("");
					$('#cadastrarMedico').modal('hide');
					MedicoController.list();
					MedicoController.limparDadosMedicoModal();
			    }
			});
		}
		else {
			MedicoController.update(idMedicoToEdit);
		}
		
	}
	
	this.update = function(idMedico) {
		var medico = this.getDadosMedicoModal();
		
		$.ajax({
		    url: '/medicos/'+idMedico,
		    method: 'PUT',
		    contentType: "application/json; charset=utf-8",
    		dataType: "json",
			data: JSON.stringify(medico),
		    success: function(result) {
		        $("#medicoId").val("");
				$('#cadastrarMedico').modal('hide');
				MedicoController.list();
				MedicoController.limparDadosMedicoModal();
		    },
		    error: function(request,msg,error) {
		       $("#medicoId").val("");
			   $('#cadastrarMedico').modal('hide');
			   MedicoController.list();
			   MedicoController.limparDadosMedicoModal();
		    }
		});
	}
	
	this.edit = function(idMedico) {
		$("#medicoId").val(idMedico);
		
		$.get( "/medicos/" + idMedico, function( data ) {
			$('#cadastrarMedico').modal('show');
			MedicoController.setDadosMedicoModal(data);
		});
	}
	
	this.setDadosMedicoModal = function(medico) {
		$('#medicoNome').val(medico.nome),
		$('#medicoCrm').val(medico.crm)
	}
	
	this.limparDadosMedicoModal = function() {
		$('#medicoNome').val(''),
		$('#medicoCrm').val('')
	}
		
	this.getDadosMedicoModal = function() {
		var medico = {
			nome: $('#medicoNome').val(),
			crm: $('#medicoCrm').val()
		}
		
		return medico;
	}
	
}
