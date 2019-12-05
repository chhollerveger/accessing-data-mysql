package com.project.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/aluno")
public class MainController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping(path = "/create")
    public @ResponseBody String createAluno(@RequestParam String name, @RequestParam String curso) {

        Aluno aluno = new Aluno();
        aluno.setName(name);
        aluno.setCurso(curso);
        alunoRepository.save(aluno);
        return "Salvo";
    }

    @GetMapping(path = "/read/all")
    public @ResponseBody Iterable<Aluno> readAllAlunos() {
        return alunoRepository.findAll();
    }

    @GetMapping(path = {"/read/{id}"})
    @ResponseBody
    public ResponseEntity<Aluno> readAluno(@PathVariable Integer id) {
        return alunoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseBody
    public void deleteAluno(@PathVariable Integer id) {
        alunoRepository.deleteById(id);
    }

    @PutMapping(path = "/update/{id}")
    @ResponseBody
    public Aluno updateAluno(@RequestBody Aluno newAluno, @PathVariable Integer id) {

        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setName(newAluno.getName());
                    aluno.setCurso(newAluno.getCurso());
                    return alunoRepository.save(aluno);
                })
                .orElseGet(() -> {
                    newAluno.setId(id);
                    return alunoRepository.save(newAluno);
                });
    }

}
