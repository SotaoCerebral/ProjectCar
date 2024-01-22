create table veiculos(

    id bigint not null auto_increment,
    proprietario varchar(100) not null,
    cpf varchar(100) not null unique,
    placa varchar(6) not null unique,
    marca varchar(100) not null,
    modelo varchar(100) not null,
    chassi varchar(100) not null,
    licenciado varchar(9) not null,


    primary key(id)

);