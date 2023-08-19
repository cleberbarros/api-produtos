insert into public.tb_categoria (id,nome,situacao) values (1,'Limpeza','ATIVO');
insert into public.tb_categoria (id,nome,situacao) values (2,'Cereais','ATIVO');
insert into public.tb_categoria (id,nome,situacao) values (3,'Bebidas','ATIVO');
insert into public.tb_categoria (id,nome,situacao) values (4,'Cama e Mesa','ATIVO');

insert into public.tb_produto (id, codigo_de_barras, descricao, nome, preco, referencia, situacao, validade, categoria_id) values (1,'123456789', 'Vinho tinto seco', 'Vinho do porto', 88.80, 'REF123', 'ATIVO', '2024-12-31', 3);
insert into public.tb_produto (id, codigo_de_barras, descricao, nome, preco, referencia, situacao, validade, categoria_id) values (2,'5555555', 'Arroz Branco 10KG', 'Arroz tio João', 77.10, 'REF1234', 'ATIVO', '2024-12-31', 2);
insert into public.tb_produto (id, codigo_de_barras, descricao, nome, preco, referencia, situacao, validade, categoria_id) values (3, '88888', 'Sabão em pó', 'Sabão omo', 20.80, 'REF008', 'ATIVO', '2024-12-31', 1);
insert into public.tb_produto (id, codigo_de_barras, descricao, nome, preco, referencia, situacao, validade, categoria_id) values (4, '744414', 'Lençol para inverno', 'Lençol inverno coala', 150.80, 'REF008', 'ATIVO', '2024-12-31', 4);


