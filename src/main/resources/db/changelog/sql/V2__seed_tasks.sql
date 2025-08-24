--liquibase formatted sql

--changeset pixies:2
INSERT INTO tasks (title, description, completed) VALUES
  ('Estudar Java', 'Revisar generics, streams e threads', false),
  ('Finalizar projeto TODO', 'Concluir funcionalidades e ajustes finais', false),
  ('Enviar e-mail para mentor', 'Compartilhar progresso do projeto TODO', false),
  ('Comer pão de queijo', 'Prioridade máxima! ☕️', true);
