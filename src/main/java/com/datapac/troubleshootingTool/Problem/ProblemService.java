package com.datapac.troubleshootingTool.Problem;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProblemService {
    private final ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    // create
    public Problem createProblem(Problem problem) {
        return problemRepository.save(problem);
    }

    // read all
    public List<Problem> getAllProblems() {
        List<Problem> problems = problemRepository.findAll();
        return problems;
    }

    // read by id
    public Problem findProblemById(Long id) {
        return problemRepository.findById(id).get();
    }

    // update
    public Problem updateCustomer(Problem problem, Long id) {
    	Problem foundProblem = problemRepository.findById(id).get();

        foundProblem.setDescription(problem.getDescription());

        return problemRepository.save(foundProblem);
    }

    // delete
    public String deleteProblem(Long id) {
        problemRepository.deleteById(id);
        return "Problem deleted.";
    }

}
