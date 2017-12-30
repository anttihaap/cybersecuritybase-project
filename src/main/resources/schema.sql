/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  antti
 * Created: 29.12.2017
 */

CREATE TABLE Users
(username VARCHAR(15),
password VARCHAR(40)
);

CREATE TABLE Signup (
    id int unsigned auto_increment not null,
    username VARCHAR(20) not null,
    address VARCHAR(50) not null
);