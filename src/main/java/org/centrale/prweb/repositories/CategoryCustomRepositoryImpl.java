/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.prweb.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author muruowang
 */
public class CategoryCustomRepositoryImpl implements CategoryCustomRepository {

    @Autowired
    @Lazy
    CategoryRepository categoryReposity;
}
