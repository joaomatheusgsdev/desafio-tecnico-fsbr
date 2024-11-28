     function limpa_formulario_cep() {
            //Limpa valores do formulario de cep.
                document.getElementById('formCliente:bairro').value="...";
                document.getElementById('formCliente:cidade').value="";
                document.getElementById('formCliente:estado').value="";
                document.getElementById('formCliente:endereco').value="";
                document.getElementById('formCliente:nome').value="";
                document.getElementById('formCliente:email').value="";
                document.getElementById('formCliente:telefone').value="";
                


    }

    function meu_callback(conteudo) {
        if (!("erro" in conteudo)) {
            //Atualiza os campos com os valores.
            document.getElementById('formCliente:endereco').value=(conteudo.logradouro);
            document.getElementById('formCliente:bairro').value=(conteudo.bairro);
            document.getElementById('formCliente:cidade').value=(conteudo.localidade);
            document.getElementById('formCliente:estado').value=(conteudo.uf);
            document.getElementById('formCliente:cep').value=(conteudo.cep);

        } //end if.
        else {
            //CEP não Encontrado.
            limpa_formulario_cep();
            alert("CEP não encontrado.");
        }
    }
        
    function pesquisacep(valor) {

        //Nova variavel "cep" somente com dígitos.
        var cep = valor.replace(/\D/g, '');

		console.log(cep)

        //Verifica se campo cep possui valor informado.
        if (cep != "") {

            //Expressão regular para validar o CEP.
            var validacep = /^[0-9]{8}$/;

            //Valida o formato do CEP.
            if(validacep.test(cep)) {

                //Preenche os campos com "..." enquanto consulta webservice.
                document.getElementById('formCliente:bairro').value="...";
                document.getElementById('formCliente:cidade').value="...";
                document.getElementById('formCliente:estado').value="...";
                document.getElementById('formCliente:endereco').value="...";

                //Cria um elemento javascript.
                var script = document.createElement('script');

                //Sincroniza com o callback.
                script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

                //Insere script no documento e carrega o conteúdo.
                document.body.appendChild(script);

            } //end if.
            else {
                //cep é invalido.
                limpa_formulario_cep();
                alert("Formato de CEP invalido.");
            }
        } //end if.
        else {
            //cep sem valor, limpa formulario.
            limpa_formulario_cep();
        }
    };
