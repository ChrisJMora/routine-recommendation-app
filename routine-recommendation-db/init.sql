-- Active: 1720195981834@@127.0.0.1@5432@exercise
CREATE SCHEMA IF NOT EXISTS rutinas;

CREATE TABLE rutinas.tipo(
    tipo_id SERIAL,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (tipo_id)
);

CREATE TABLE rutinas.ejercicio(
    ejercicio_id SERIAL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    series INT NOT NULL,
    repeticiones INT NOT NULL,
    duracion TIME NOT NULL,
    descanso TIME NOT NULL,
    grupo_muscular VARCHAR(100) NOT NULL,
    meta VARCHAR(100) NOT NULL,
    PRIMARY KEY (ejercicio_id),
    CONSTRAINT grupo_muscular_check 
		CHECK (grupo_muscular IN ('Parte Superior', 'Parte Media', 'Parte Inferior', 'Todo el Cuerpo')),
    CONSTRAINT meta_check 
		CHECK (meta IN ('Bajar Peso', 'Mantener Peso', 'Subir Peso'))
);

CREATE TABLE rutinas.tipo_ejercicio(
    tipo_id INT NOT NULL,
    ejercicio_id INT NOT NULL,
    PRIMARY KEY (tipo_id, ejercicio_id),
    FOREIGN KEY (tipo_id) 
        REFERENCES rutinas.tipo(tipo_id),
    FOREIGN KEY (ejercicio_id) 
        REFERENCES rutinas.ejercicio(ejercicio_id)
);

INSERT INTO rutinas.tipo(tipo_id, nombre)
VALUES
    (1, 'Ejercicio compuesto'),
    (2, 'Ejercicio de aislamiento'),
    (3, 'Ejercicio con pesas libres'),
    (4, 'Ejercicio con máquinas'),
    (5, 'Ejercicio con propio peso corporal'),
    (6, 'Ejercicio de alta intensidad (HIIT)'),
    (7, 'Ejercicio de resistencia variable'),
    (8, 'Ejercicio de pilometría');

INSERT INTO rutinas.ejercicio (ejercicio_id, nombre, descripcion, series, repeticiones, duracion, descanso, grupo_muscular, meta)
VALUES
    (1,'Press de banca', 'Ejercicio compuesto que trabaja principalmente el pecho.', 4, 10, '00:00:45', '00:01:00', 'Parte Superior', 'Subir Peso'),
    (2,'Curl de bíceps con mancuernas', 'Ejercicio de aislamiento para los bíceps.', 3, 12, '00:00:30', '00:01:00', 'Parte Superior', 'Mantener Peso'),
    (3,'Sentadilla con barra', 'Ejercicio compuesto que trabaja principalmente las piernas.', 4, 10, '00:00:45', '00:01:30', 'Parte Inferior', 'Subir Peso'),
    (4,'Remo con barra', 'Ejercicio compuesto que trabaja la espalda.', 4, 10, '00:00:45', '00:01:00', 'Parte Superior', 'Subir Peso'),
    (5,'Peso muerto', 'Ejercicio compuesto que trabaja todo el cuerpo.', 3, 8, '00:00:45', '00:01:30', 'Parte Inferior', 'Subir Peso'),
    (6,'Press militar', 'Ejercicio compuesto que trabaja los hombros.', 3, 10, '00:00:45', '00:01:00', 'Parte Superior', 'Subir Peso'),
    (7,'Elevación lateral de hombros', 'Ejercicio de aislamiento para los hombros.', 3, 12, '00:00:30', '00:01:00', 'Parte Superior', 'Mantener Peso'),
    (8,'Dominadas', 'Ejercicio con propio peso corporal que trabaja la espalda y los bíceps.', 3, 10, '00:00:45', '00:01:00', 'Parte Superior', 'Subir Peso'),
    (9,'Flexiones', 'Ejercicio con propio peso corporal que trabaja el pecho y los tríceps.', 4, 15, '00:00:30', '00:01:00', 'Parte Superior', 'Mantener Peso'),
    (10,'Burpees', 'Ejercicio de alta intensidad que trabaja todo el cuerpo.', 3, 20, '00:00:30', '00:01:00', 'Parte Superior', 'Bajar Peso'),
    (11,'Plancha', 'Ejercicio isométrico que trabaja el core.', 3, 1, '00:01:00', '00:01:00', 'Parte Media', 'Mantener Peso'),
    (12,'Saltos al cajón', 'Ejercicio de pliometría que trabaja las piernas.', 3, 15, '00:00:30', '00:01:00', 'Parte Inferior', 'Bajar Peso'),
    (13,'Mountain climbers', 'Ejercicio de alta intensidad que trabaja el core y las piernas.', 3, 20, '00:00:30', '00:01:00', 'Parte Media', 'Bajar Peso'),
    (14,'Peso muerto rumano', 'Ejercicio con pesas libres que trabaja los isquiotibiales.', 3, 10, '00:00:45', '00:01:00', 'Parte Inferior', 'Mantener Peso'),
    (15,'Zancadas', 'Ejercicio compuesto que trabaja las piernas.', 3, 12, '00:00:45', '00:01:00', 'Parte Inferior', 'Subir Peso'),
    (16,'Press de piernas', 'Ejercicio con máquina que trabaja las piernas.', 4, 10, '00:00:45', '00:01:30', 'Parte Inferior', 'Subir Peso'),
    (17,'Crunch abdominal', 'Ejercicio de aislamiento que trabaja el abdomen.', 3, 15, '00:00:30', '00:01:00', 'Parte Media', 'Mantener Peso'),
    (18,'Levantamiento de pantorrillas', 'Ejercicio de aislamiento que trabaja las pantorrillas.', 3, 15, '00:00:30', '00:01:00', 'Parte Inferior', 'Mantener Peso'),
    (19,'Encogimiento de hombros', 'Ejercicio de aislamiento que trabaja los trapecios.', 3, 12, '00:00:30', '00:01:00', 'Parte Superior', 'Mantener Peso'),
    (20,'Jalón al pecho', 'Ejercicio con máquina que trabaja la espalda.', 3, 12, '00:00:45', '00:01:00', 'Parte Superior', 'Mantener Peso'),
    (21,'Tijeras (Jumping Jacks)', 'Ejercicio de alta intensidad que trabaja todo el cuerpo.', 3, 30, '00:00:30', '00:01:00', 'Todo el Cuerpo', 'Bajar Peso'),
    (22,'Sprints', 'Ejercicio de alta intensidad que trabaja principalmente las piernas y el sistema cardiovascular.', 6, 50, '00:00:15', '00:01:00', 'Parte Inferior', 'Bajar Peso'),
    (23,'Cuerda de saltar (Jump Rope)', 'Ejercicio de alta intensidad que trabaja todo el cuerpo.', 3, 2, '00:02:00', '00:01:00', 'Todo el Cuerpo', 'Bajar Peso'),
    (24,'Tabata', 'Ejercicio de alta intensidad que incluye 8 rondas de 20 segundos de trabajo y 10 segundos de descanso.', 1, 8, '00:04:00', '00:02:00', 'Todo el Cuerpo', 'Bajar Peso'),
    (25,'High Knees', 'Ejercicio de alta intensidad que trabaja principalmente las piernas y el core.', 3, 30, '00:00:30', '00:01:00', 'Parte Inferior', 'Bajar Peso'),
    (26,'Battle Ropes', 'Ejercicio de alta intensidad que trabaja los brazos, hombros y core.', 3, 30, '00:00:30', '00:01:00', 'Parte Superior', 'Bajar Peso');

INSERT INTO rutinas.tipo_ejercicio (tipo_id, ejercicio_id)
VALUES
    (1, 1),  -- Press de banca - Ejercicio compuesto
    (2, 2),  -- Curl de bíceps con mancuernas - Ejercicio de aislamiento
    (1, 3),  -- Sentadilla con barra - Ejercicio compuesto
    (1, 4),  -- Remo con barra - Ejercicio compuesto
    (1, 5),  -- Peso muerto - Ejercicio compuesto
    (1, 6),  -- Press militar - Ejercicio compuesto
    (2, 7),  -- Elevación lateral de hombros - Ejercicio de aislamiento
    (5, 8),  -- Dominadas - Ejercicio con propio peso corporal
    (5, 9),  -- Flexiones - Ejercicio con propio peso corporal
    (6, 10), -- Burpees - Ejercicio de alta intensidad (HIIT)
    (5, 11), -- Plancha - Ejercicio con propio peso corporal
    (8, 12), -- Saltos al cajón - Ejercicio de pliometría
    (6, 13), -- Mountain climbers - Ejercicio de alta intensidad (HIIT)
    (3, 14), -- Peso muerto rumano - Ejercicio con pesas libres
    (1, 15), -- Zancadas - Ejercicio compuesto
    (4, 16), -- Press de piernas - Ejercicio con máquinas
    (2, 17), -- Crunch abdominal - Ejercicio de aislamiento
    (2, 18), -- Levantamiento de pantorrillas - Ejercicio de aislamiento
    (2, 19), -- Encogimiento de hombros - Ejercicio de aislamiento
    (4, 20), -- Jalón al pecho - Ejercicio con máquinas
    (6, 21), -- Tijeras (Jumping Jacks) - Ejercicio de alta intensidad (HIIT)
    (6, 22), -- Sprints - Ejercicio de alta intensidad (HIIT)
    (6, 23), -- Cuerda de saltar (Jump Rope) - Ejercicio de alta intensidad (HIIT)
    (6, 24), -- Tabata - Ejercicio de alta intensidad (HIIT)
    (6, 25), -- High Knees - Ejercicio de alta intensidad (HIIT)
    (6, 26); -- Battle Ropes - Ejercicio de alta intensidad (HIIT)
