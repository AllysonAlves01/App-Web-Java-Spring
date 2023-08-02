package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.domain.filme.DadosAlteracaoFilme;
import br.com.alura.screenmatch.domain.filme.DadosCadastroFilme;
import br.com.alura.screenmatch.domain.filme.Filme;
import br.com.alura.screenmatch.domain.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes") //ANOTAÇÃO PARA MAPEAR QUANDO A URL FOR DIGITA /FILMES
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

     @GetMapping("/formulario") // se for get chama esse metodo formulario
     public String carregaPaginaFormulario(Long id , Model model){
         if (id != null){
             var filme = repository.getReferenceById(id); // Repository= congregant informants do banco de dado's
             model.addAttribute("filme", filme);
         }
         return "filmes/formulario";

     }
    @GetMapping // se for get chama esse metodo formulario
    public String carregaPaginaListagem(Model model){ // IMPORTANDO CLASSE MODEL PARA FAZER O PROCEDIMENTO
         model.addAttribute("lista" , repository.findAll());

        return "filmes/listagem";

    }

     @PostMapping /// se for post chama esse metodo
     @Transactional
  public String cadastraFilme(DadosCadastroFilme dados){
         var filme = new Filme(dados);
         repository.save(filme);

      return "redirect:/filmes";
  }

    @PutMapping
    @Transactional // INICIANDO TRANSAÇÃO COM O BANCO
    public String alteraFilme(DadosAlteracaoFilme dados){
        var filme = repository.getReferenceById(dados.id());
        filme.atualizaDados(dados);

        return "redirect:/filmes";
    }
  @DeleteMapping
  @Transactional
  public String removeFilme(Long id){
      repository.deleteById(id);
      return "redirect:/filmes";
  }
}
