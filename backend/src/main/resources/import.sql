
/*
--insert into libro_bibliografia (asignatura_id,autor,editorial, numero_edicion, observaciones, recurso,serie, sugerencias, titulo, url, year) values(1,'paulo cohelo', 'San Rey',1,'No posee',1,1,'No posee','algun titulo','No posee','12/12/2012');

--ingreso de usuarios
SET IDENTITY_INSERT usuario ON
insert into usuario (correo,nombre,password,habilitado) values ('adalton.penate@ues.edu.sv','Adalton Rivelino Peñate Carranza','$2a$10$2rbQXDuBBtxm0CmmUWrzcu0jZypB68zmCEbjp6IpcGsKzGtR6PeGG',1)
insert into usuario (correo,nombre,password,habilitado) values ('ana.aguirre@ues.edu.sv','Ana Beatriz Aguirre Villalta','$2a$10$K9UbKtKhlHfR1FJgUH9IvuBXVYe.BwRKbpj9VLEbZPbGivBcwrysO',1)
insert into usuario (correo,nombre,password,habilitado) values ('esmeralda.quintanilla@ues.edu.sv','Esmeralda Del Carmen Quintanilla Segovia','$2a$10$TysMqy9g.2UtNFBuYt0HWeZuCPXPYAOgK8UtqeKSubCpDbvjWvCTq',1)

--SET IDENTITY_INSERT asignatura ON
--insert into asignatura (id,nombre,usuario_id) values(1,'matemática',1)
--insert into asignatura (id,nombre,usuario_id) values(2,'programacion 1',2)

--ingreso de roles
insert into role (nombre) values ('ROLE_DOCENTE')
insert into role (nombre) values ('ROLE_ADMIN')

--INGRESO DE USUARIOS Y SUS ROLES

insert into usuario_roles (usuario_id, roles_id) values (1,1)
insert into usuario_roles (usuario_id, roles_id) values (2,1)
insert into usuario_roles (usuario_id, roles_id) values (3,2)

-- departamentos
insert into departamento (nombre_depto) values ('Informática')
insert into departamento (nombre_depto) values ('Contaduria')

-- carreras
insert into carrera (nombre,departamento_id) values ('Ingeniería de Sistemas Informáticos',1)
insert into carrera (nombre,departamento_id) values ('Contaduría pública',2)

--asignaturas
insert into asignatura (nombre,carrera_id) values ('Matemática 1',1)
insert into asignatura (nombre,carrera_id) values ('Programacíon 1',1)
insert into asignatura (nombre,carrera_id) values ('Contaduría 1',2)
insert into asignatura (nombre,carrera_id) values ('Contaduría 2',2)

--Usuario_Asignaturas
insert into usuario_asignaturas (usuario_id,asignaturas_id) values (1,1)
insert into usuario_asignaturas (usuario_id,asignaturas_id) values (1,3)
insert into usuario_asignaturas (usuario_id,asignaturas_id) values (2,2)

--Bibliografias
insert into libro_bibliografia (usuariolb_id,asignatura_id,autor,editorial, numero_edicion, observaciones, recurso,serie, sugerencias, titulo, url, year) values(1,1,'Larson', 'San Rey',1,'No posee',1,1,'No posee','Matemática de larson','No posee','12/12/2012');
insert into libro_bibliografia (usuariolb_id,asignatura_id,autor,editorial, numero_edicion, observaciones, recurso,serie, sugerencias, titulo, url, year) values(2,2,'Autor anonimo', 'San Rey',1,'No posee',1,1,'No posee','Administracion de la contaduria publica','No posee','12/12/2012');
insert into libro_bibliografia (usuariolb_id,asignatura_id,autor,editorial, numero_edicion, observaciones, recurso,serie, sugerencias, titulo, url, year) values(2,3,'Steve job', 'San Rey',1,'No posee',1,1,'No posee','Introduccion a xamarin','No posee','12/12/2012');
insert into libro_bibliografia (usuariolb_id,asignatura_id,autor,editorial, numero_edicion, observaciones, recurso,serie, sugerencias, titulo, url, year) values(2,4,'Bill gates', 'Microsoft',1,'No posee',1,1,'No posee','Netcore','No posee','12/12/2012');
*/
