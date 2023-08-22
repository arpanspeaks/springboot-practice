package com.example.springbootpractice.service;

import com.example.springbootpractice.entity.Employee;
import com.example.springbootpractice.pojo.SearchRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EntityManager entityManager;

    public List<Employee> findAllBySimpleQuery(String firstname, String lastname, String email) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        Root<Employee> root = criteriaQuery.from(Employee.class);

        Predicate firstnamePredicate = criteriaBuilder
                .like(root.get("firstname"), "%" + firstname + "%");

        Predicate lastnamePredicate = criteriaBuilder
                .like(root.get("lastname"), "%" + lastname + "%");

        Predicate emailPredicate = criteriaBuilder.equal(root.get("email"), email);

        Predicate namePredicate = criteriaBuilder.and(firstnamePredicate, lastnamePredicate);

        Predicate finalPredicate = criteriaBuilder.or(namePredicate, emailPredicate);

        criteriaQuery.where(finalPredicate);

        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();

    }

    public List<Employee> findAllBySearchQuery(SearchRequest req) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        List<Predicate> predicates = new ArrayList<>();

        Root<Employee> root = criteriaQuery.from(Employee.class);

        if(req.getFirstname() != null) {
            Predicate firstnamePredicate = criteriaBuilder
                    .like(root.get("firstname"), "%" + req.getFirstname() + "%");
            predicates.add(firstnamePredicate);
        }

        if(req.getLastname() != null) {
            Predicate lastnamePredicate = criteriaBuilder
                    .like(root.get("lastname"), "%" + req.getLastname() + "%");
            predicates.add(lastnamePredicate);
        }

        if(req.getLastname() != null) {
            Predicate emailPredicate = criteriaBuilder
                    .equal(root.get("email"), req.getEmail());
            predicates.add(emailPredicate);
        }

        criteriaQuery.where(
          criteriaBuilder.or(predicates.toArray(new Predicate[0]))
        );

        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();

    }

}
