package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.domain.filme.DadosCadastroFilme;
import br.com.alura.screenmatch.domain.filme.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes") //ANOTAÇÃO PARA MAPEAR QUANDO A URL FOR DIGITA /FILMES
public class FilmeController {

    private List<Filme> filmes = new ArrayList<>();

     @GetMapping("/formulario") // se for get chama esse metodo formulario
     public String carregaPaginaFormulario(){

         return "filmes/formulario";

     }
    @GetMapping // se for get chama esse metodo formulario
    public String carregaPaginaListagem(Model model){ // IMPORTANDO CLASSE MODEL PARA FAZER O PROCEDIMENTO
         model.addAttribute("lista" , filmes); //ENVIANDO INFORMAÇÕES PARA A PAGIMA O HTML --

        return "filmes/listagem";

    }

     @PostMapping /// se for post chama esse metodo
  public String cadastraFilme(DadosCadastroFilme dados){
         var filme = new Filme(dados);
         filmes.add(filme);

      return "redirect:/filmes";
  }
}
