var AtendimentoController = new function() {
	
	this.list = function() {
		$('#atendimentosTableBody').empty();
		
		$.get( "/atendimentos", function( data ) {
			$.each(data, function(i, item) {
		        $('<tr>').append(
		            $('<td>').text(item.idAtendimento),
		            $('<td>').text(item.dataHora),
					$('<td>').text(item.modalidade),
					$('<td>').text(item.medico),
					$('<td>').text(item.paciente),
					$('<td class="actions"><a class="btn btn-warning btn-xs" onclick="AtendimentoController.edit('+item.idAtendimento+')">Editar</a><a class="btn btn-danger btn-xs" onclick="AtendimentoController.delete('+item.idAtendimento+')">Excluir</a></td>')
		        ).appendTo('#atendimentosTableBody');
		    });
		});
	}
	
	this.delete = function(idAtendimento) {
		$.ajax({
		    url: '/atendimentos/'+idAtendimento,
		    method: 'DELETE',
		    contentType: 'application/json',
		    success: function(result) {
		        AtendimentoController.list();
		    },
		    error: function(request,msg,error) {
		        alert('erro ao deletar');
		    }
		});
	}
	
	this.save = function() {
		var idAtendimentoToEdit = $("#atendimentoId").val();
		
		if (idAtendimentoToEdit == null || idAtendimentoToEdit == "") {
			var atendimento = this.getDadosAtendimentoModal();
			
			$.ajax({
			    url: '/atendimentos',
			    type: 'POST',
			    contentType: "application/json; charset=utf-8",
	    		dataType: "json",
				data: JSON.stringify(atendimento),
			    success: function() {
			        $("#atendimentoId").val("");
					$('#cadastrarAtendimento').modal('hide');
					AtendimentoController.list();
					AtendimentoController.limparDadosAtendimentoModal();
			    },
			    error: function(request,msg,error) {
			       $("#atendimentoId").val("");
					$('#cadastrarAtendimento').modal('hide');
					AtendimentoController.list();
					AtendimentoController.limparDadosAtendimentoModal();
			    }
			});
		}
		else {
			AtendimentoController.update(idAtendimentoToEdit);
		}
		
	}
	
	this.update = function(idAtendimento) {
		var atendimento = this.getDadosAtendimentoModal();
		
		$.ajax({
		    url: '/atendimentos/'+idAtendimento,
		    method: 'PUT',
		    contentType: "application/json; charset=utf-8",
    		dataType: "json",
			data: JSON.stringify(atendimento),
		    success: function(result) {
		        $("#atendimentoId").val("");
				$('#cadastrarAtendimento').modal('hide');
				AtendimentoController.list();
				AtendimentoController.limparDadosAtendimentoModal();
		    },
		    error: function(request,msg,error) {
		       $("#atendimentoId").val("");
			   $('#cadastrarAtendimento').modal('hide');
			   AtendimentoController.list();
			   AtendimentoController.limparDadosAtendimentoModal();
		    }
		});
	}
	
	this.edit = function(idAtendimento) {
		$("#atendimentoId").val(idAtendimento);
		
		$.get( "/atendimentos/" + idAtendimento, function( data ) {
			$('#cadastrarAtendimento').modal('show');
			AtendimentoController.setDadosAtendimentoModal(data);
		});
	}
	
	this.setDadosAtendimentoModal = function(atendimento) {
		$('#atendimentoDataHora').val(atendimento.dataHora),
		$('#atendimentoModalidade').val(atendimento.modalidade),
		$('#atendimentoMedico').val(atendimento.medico),
		$('#atendimentoPaciente').val(atendimento.paciente)
	}
	
	this.limparDadosAtendimentoModal = function() {
		$('#atendimentoDataHora').val(''),
		$('#atendimentoModalidade').val(''),
		$('#atendimentoMedico').val(''),
		$('#atendimentoPaciente').val('')
	}
		
	this.getDadosAtendimentoModal = function() {
		var atendimento = {
			dataHora: $('#atendimentoDataHora').val(),
			modalidade: $('#atendimentoModalidade').val(),
			medico: $('#atendimentoMedico').val(),
			paciente: $('#atendimentoPaciente').val()
		}
		
		return atendimento;
	}
	
}
