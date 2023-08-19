insert into public.tb_categoria (id,nome,situacao) values (100,'Limpeza','ATIVO');
insert into public.tb_categoria (id,nome,situacao) values (200,'Cereais','ATIVO');
insert into public.tb_categoria (id,nome,situacao) values (300,'Bebidas','ATIVO');
insert into public.tb_categoria (id,nome,situacao) values (400,'Cama e Mesa','ATIVO');

insert into public.tb_produto (id, codigo_de_barras, descricao, nome, preco, referencia, situacao, validade, categoria_id) values (100,'123456789', 'Vinho tinto seco', 'Vinho do porto', 88.80, 'REF123', 'ATIVO', '2024-12-31', 300);
insert into public.tb_produto (id, codigo_de_barras, descricao, nome, preco, referencia, situacao, validade, categoria_id) values (200,'5555555', 'Arroz Branco 10KG', 'Arroz tio João', 77.10, 'REF1234', 'ATIVO', '2024-12-31', 200);
insert into public.tb_produto (id, codigo_de_barras, descricao, nome, preco, referencia, situacao, validade, categoria_id) values (300, '88888', 'Sabão em pó', 'Sabão omo', 20.80, 'REF008', 'ATIVO', '2024-12-31', 100);
insert into public.tb_produto (id, codigo_de_barras, descricao, nome, preco, referencia, situacao, validade, categoria_id) values (400, '744414', 'Lençol para inverno', 'Lençol inverno coala', 150.80, 'REF008', 'ATIVO', '2024-12-31', 400);


