%% Autor: Alden
%% Fecha: 09/09/2010
:- dynamic resH/2.
%******************Base de Hechos******************
%-----Requisitos-----
requisito('Requ','No es Requisito').
requisito('Requ1.0','La relación sustancial no es la misma que la relación jurídica procesal').

requisito('Requ2.0','Demandante carece manifiestamente de interés para obrar').

requisito('Requ3.0','Interpuso la demanda 60 dias hábiles posteriores de producida la afectación').
requisito('Requ3.1','El afectado tuvo conocimiento del acto lesivo').
requisito('Requ3.2','Los actos que constituyen la afectación no son continuados').

requisito('Requ6.0','Juez no es Juez mixto').

requisito('Requ7.0','No existe conexión lógica entre los hechos y el petitorio').

requisito('Requ8.0','El petitorio es jurídica y físicamente imposible').

requisito('Requ9.0','La demanda contiene una indebida acumulación de pretensiones').

requisito('Requ10.0','Se ha reclamado previamente ante el empleador').
requisito('Requ10.1','La agresión no pudiera convertirse en irreparable').
requisito('Requ10.2','Hay duda sobre el agotamiento de la vía previa').

requisito('Requ10.3','La pretensión de la demanda está referida a la inaplicación de normas autoaplicativas').

requisito('Requ11.0','Lo que se indica como hechos y lo que se pretende es válido y se derivan directamente del contenido esencial de un derecho protegido por una disposición constitucional').

requisito('Requ12.0','El agraviado ha recurrido previamente a otro proceso judicial para pedir tutela respecto de su derecho constitucional').

requisito('Requ13.0','A la presentación de la demanda ha cesado la amenaza o violación de un derecho constitucional o se ha convertido en irreparable').

requisito('Requ14.0','Se cuestiona una resolución firme recaída en otro proceso constitucional o haya litisdependencia').

%-----Regimen Laboral Privado-----
%->Grupo NÂº1(Despido Fraudulento) uno solo
criterio('F','Fue despedido fraudulentamente').
criterio('F1','Solicita la reposición').
              criterio('F1.1','En la vía ordinaria no es posible obtener la reposición').
              criterio('F1.2','En la vía ordinaria no es posible obtener la restitución del derecho vulnerado').
criterio('F2','Acredita fehacientemente que existía fraude en el despido').
criterio('F3','Acredita indubitablemente que existía fraude en el despido').
criterio('F4','Es urgente').
criterio('F5','Demuestra objetivamente que la vía laboral ordinaria no es la idónea').
criterio('F6','Demuestra fehacientemente que la vía laboral ordinaria no es la idónea').
criterio('F7','Hay controversia en los hechos').
criterio('F8','Hay duda en los hechos').
criterio('F9','Cobró la indemnización por despido arbitrario').
criterio('F10','Cobró la indemnización por otro concepto con el mismo fin (por ejemplo incentivos)').

%->Grupo NÂº2(Despido Nulo)
criterio('N','Fue despedido nulo').
%->Grupo NÂº2.1"Relativas a la libertad sindical y al derecho de sindicaciÃ³n")
criterio('N1','Relativas a la libertad sindical y al derecho de sindicación').
   criterio('N1.1','Por afiliarce  a un sindicato lesionándose su derecho de sindicación y libertad sindical').
   criterio('N1.2','Por participar en actividades sindicales fuera de las horas de trabajo').
   criterio('N1.3','Por participar en actividades sindicales con consentimiento del empleador durante las horas de trabajo').
   criterio('N1.4','Por participar en la negociación colectiva').
   criterio('N1.5','Por participar en ejercicio del derecho de huelga').

%->Grupo NÂº2.2(Despido Nulo "Originado por discriminacion por raza, sexo, religion, etc")
criterio('N2','Originado por discriminación por raza, sexo, religión, etc').
    criterio('N2.1','Por razón de sexo').
    criterio('N2.2','Por razón de raza').
    criterio('N2.3','Por razón de opinión').
    criterio('N2.4','Por razón de idioma').
    criterio('N2.5','Por razón de estado civil').
    criterio('N2.6','Por razón de cualquier otra índole').

%->Grupo NÂº2.3(Despido Nulo "Originado por discriminacion por embarazo")
criterio('N3','Originado por discriminación por embarazo').
    criterio('N3.1','Porque estaba embarazada').
    criterio('N3.2','Despido se produce mientras estaba gestando'). %*
    criterio('N3.3','Empleador fue notificado del embarazo').
    criterio('N3.4','Despido se produce dentro de los 90 dias posteriores al parto').

%->Grupo NÂº2.4(Despido Nulo "Originado por discriminacion por impedido fisico y mental")
criterio('N4','Originado por discriminación por impedido fisico y mental').
    criterio('N4.1','Es impedido fisico').
    criterio('N4.2','Es impedido  mental').

%->Grupo NÂº3 (Despido Incausado) uno solo
criterio('IC','Fue despido incausado').
criterio('IC1','Solicita la reposición').
   criterio('IC1.1','En la vía ordinaria no es posible obtener la reposición').
   criterio('IC1.2','En la vía ordinaria no es posible obtener la restitución del derecho vulnerado').
criterio('IC2','Acredita fehacientemente que no existe causa alguna derivada de la conducta o labor que la justifique').
criterio('IC3','Acredita indubitablemente que no existe causa alguna derivada de la conducta o labor que la justifique').
criterio('IC4','Acredita fehacientemente que los hechos que se imputan son notoriamente inexistentes, falsos o imaginarios').
criterio('IC5','Acredita indubitablemente que los hechos que se le imputan son notoriamente inexistentes, falsos o imaginarios').
criterio('IC6','Acredita fehacientemente que se le atribuye una falta no prevista legalmente').
criterio('IC7','Acredita Indubitablemente que se le atribuye una falta no prevista legalmente').
criterio('IC8','Es urgente').
criterio('IC9','Demuestra objetivamente que la vía laboral ordinaria no es la idónea').
criterio('IC10','Demuestra fehacientemente que la vía laboral ordinaria no es la idónea').
criterio('IC11','Hay controversia en los hechos').
criterio('IC12','Hay duda en los hechos').
criterio('IC13','Cobró la indemnización por despido arbitrario').
criterio('IC14','Cobró la indemnización por otro concepto con el mismo fin (por ejemplo incentivos)').

%->Grupo NÂº4 (Despido Injustificado) uno solo
criterio('IJ','Fue despido Injustificado').
criterio('IJ1','Solicita la reposición').
     criterio('IJ1.1','En la vía ordinaria no es posible obtener la reposición').
     criterio('IJ1.2','En la vía ordinaria no es posible obtener la restitución del derecho vulnerado').
criterio('IJ2','Es Urgente').
criterio('IJ3','Demuestra objetivamente que la vía laboral ordinaria no es la idónea').
criterio('IJ4','Demuestra fehacientemente que la vía laboral ordinaria no es la idónea').
criterio('IJ5','Cobro la indemnización por despido arbitrario').
criterio('IJ6','Cobro la indemnización por otro concepto con el mismo fin (por ejemplo incentivos)').
criterio('IJ7','Hay controversia en los hechos').
criterio('IJ8','Hay duda en los hechos').
                   
%-----Regimen Laboral Publico-----
%->Grupo NÂº1(PÃºblico) uno solo
criterio('P','Es Régimen Público').
criterio('P1','Es urgente').
criterio('P2','Demuestra objetivamente que la vía contenciosa administrativa no es la idónea').
criterio('P3','Demuestra fehacientemente que la vía contenciosa administrativa no es la idónea').
criterio('P4','Afiliarse a un sindicato').
criterio('P5','Desempeño de cargo sindical').
criterio('P6','Está embarazada').
criterio('P7','Impedido físico').
criterio('P8','Impedido mental').
%**************************************************

%**********************Reglas**********************
%-----Requisitos-----
regla('ReglaPorRequisito','Si no es Requisito').
regla('ReglaPorRequisito1','Si la relación sustancial no es la misma que la relación jurídica procesal entonces el demandante carece evidentemente legitimidad para obrar').
    regla('ReglaPorRequisito1.1','Si el demandante carece evidentemente de legitimidad para obrar no procede el amparo').

regla('ReglaPorRequisito2','Si el demandante carece manifiestamente de interés para obrar no procede el amparo').

regla('ReglaPorRequisito3','Si el derecho ha caducado no procede el amparo').
    regla('ReglaPorRequisito3.1','Si interpuso la demanda sesenta días hábiles posteriores de producida la afectación y el afectado tuvo conocimiento del acto lesivo y los actos que constituyen la afectación no son continuados entonces el derecho ha caducado').

regla('ReglaPorRequisito4','Si el juez carece de competencia no procede el amparo').
    regla('ReglaPorRequisito4.1','Si el Juez no es un Juez mixto el Juez carece de competencia').

regla('ReglaPorRequisito5','Si no existe conexión lógica entre los hechos y el petitorio no procede el amparo').

regla('ReglaPorRequisito6','Si el petitorio es jurídica y físicamente imposible no procede el amparo').

regla('ReglaPorRequisito7','Si la demanda contiene una indebida acumulación de pretensiones no procede el amparo').

regla('ReglaPorRequisito8','Si se ha agotado la vía previa procede el amparo').
    regla('ReglaPorRequisito8.1','Si se ha reclamado previamente ante el empleador y la agresión no pudiera convertirse en irreparable entonces se ha agotado la vía previa').
    regla('ReglaPorRequisito8.2','Si no se ha reclamado previamente ante el empleador y la agresión no pudiera convertirse en irreparable entonces no se ha agotado la vía previa').

regla('ReglaPorRequisito9','Si la agresión pudiera convertirse en irreperable procede el amparo').

regla('ReglaPorRequisito10','Si hay duda sobre el agotamiento de la vía previa procede el amparo en aplicación del principio pro actione').

regla('ReglaPorRequisito10.1','Si la pretensión de la demanda está referida a la inaplicación de normas autoaplicativas').

regla('ReglaPorRequisito11','Si los hechos y el petitorio de la demanda no están referidos en forma directa al contenido constitucionalmente protegido del derecho invocado entonces no procede el amparo').
    regla('ReglaPorRequisito11.1','Si lo que se indica como hechos y lo que se pretende es válido y se derivan directamente del contenido esencial de un derecho protegido por una disposición constitucional entonces los hechos y el petitorio de la demanda están referidos en forma directa al contenido constitucionalmente protegido del derecho invocado').

regla('ReglaPorRequisito12','Si el agraviado ha recurrido previamente a otro proceso judicial para pedir tutela respecto de su derecho constitucional no procede el amparo').

regla('ReglaPorRequisito13','Si a la presentación de la demanda ha cesado la amenaza o violación de un derecho constitucional o se ha convertido en irreparable no procede el amparo').

regla('ReglaPorRequisito14','Si se cuestiona una resolución firme recaída en otro proceso constitucional o haya litisdependencia').

%-----Regimen Laboral Privado-----
%->Grupo NÂº1(Despido Fraudulento) uno solo
regla('ReglaPorFraudulento','Si es Fraudulento').
   regla('ReglaPorFraudulento1','Si solicita la reposición al trabajo y en la vía ordinaria no es posible obtener la reposición o en la via ordinariano es posible obtener la restitución del derecho vulnerado').
   regla('ReglaPorFraudulento2','Si acredita fehacientemente e indubitablemente que existía fraude en el despido').
   regla('ReglaPorFraudulento3','Si es urgente').
   regla('ReglaPorFraudulento4','Si demuestra objetivamente y fehacientemente que la vía laboral ordinaria no es la idónea').
   regla('ReglaPorFraudulento5','Si no hay controversia en los hechos o no hay duda en los hechos').
   regla('ReglaPorFraudulento6','Si no cobró la indemnización por despido arbitrario o no cobró la indemnización por otro concepto con el mismo fin (por ejemplo incentivos) entonces procede el amparo').
%->Grupo NÂº2(Despido Nulo)
regla('ReglaPorNulo','Si es Nulo').
%->Grupo NÂº2.1"Relativas a la libertad sindical y al derecho de sindicacion")
regla('ReglaPorNulo1','Si despido es nulo por libertad sindical y al derecho de sindicación').
        regla('ReglaPorNulo1.1','Si fue despedido por afiliarse  a un sindicato lesionándose su derecho de sindicación y libertad sindical').
        regla('ReglaPorNulo1.2','Si fue despedido por participar en actividades sindicales fuera de las horas de trabajo').
        regla('ReglaPorNulo1.3','Si fue despedido por participar en actividades sindicales con consentimiento del empleador durante las horas de trabajo').
        regla('ReglaPorNulo1.4','Si fue despedido por participar en la negociación colectiva').
        regla('ReglaPorNulo1.5','Si fue despedido por participar en ejercicio del derecho de huelga').

%->Grupo NÂº2.2(Despido Nulo "Originado por discriminacion por raza, sexo, religion, etc")
regla('ReglaPorNulo2','Si despido es nulo originado por discriminación por raza,sexo,religión,etc').
    regla('ReglaPorNulo2.1','Si fue despedido por razón de sexo o por razón de raza o por razón de religión o por razón de opinión o por razón de idioma o por razón del estado civil o por razón de cualquier otra índole').

%->Grupo NÂº2.3(Despido Nulo "Originado por discriminacion por embarazo")
regla('ReglaPorNulo3','Si despido es nulo por contravenir lo dispuesto por el artículo 11 numerales  1 y 2 literales a) y d) de la Convención sobre la eliminación de las formas de discriminación contra la mujer de Naciones Unidas').
        regla('ReglaPorNulo3.1','Si fue despedida porque estaba embarazada y el despido se produce mientras esta gestando y el empleador fue notificado del embarazo').
        regla('ReglaPorNulo3.2','Si fue despedida porque estaba embarazada y el despido se produce dentro de los 90 dias posteriores al parto y el empleador fue notificado del embarazo').

%->Grupo NÂº2.4(Despido Nulo "Originado por discriminacion por impedido fisico o mental")
regla('ReglaPorNulo4','Si el despido es nulo por contravenir los artículos 7 y 23 de la Constitución y el artículo 18 del Protocolo de San Salvador').
        regla('ReglaPorNulo4.1','Si fue despedido porque es impedido físico o es impedido mental').

%->Grupo NÂº3 (Despido Incausado) uno solo
regla('ReglaPorIncausado','Si es Incausado').
regla('ReglaPorIncausado1','Si solicita la reposición al trabajo y en la vía ordinaria no es posible obtener la reposición o la restitución del derecho vulnerado procede el amparo').
regla('ReglaPorIncausado2','Si acredita fehacientemente e indubitablemente que no existe causa alguna derivada de la conducta o labor que la justifique procede el amparo').
regla('ReglaPorIncausado3','Si acredita fehacientemente e indubitablemente que los hechos que se le imputan son notoriamente inexistentes, falsos o imaginarios  procede el amparo').
regla('ReglaPorIncausado4','Si acredita fehacientemente e indubitablemente que se le atribuye una falta no prevista legalmente procede el amparo').
regla('ReglaPorIncausado5','Si es urgente procede el amparo').
regla('ReglaPorIncausado6','Si demuestra objetivamente y fehacientemente que la vía laboral ordinaria no es la idónea procede el amparo').
regla('ReglaPorIncausado7','Si no hay controversia o no hay duda en los hechos procede el amparo').
regla('ReglaPorIncausado8','Si no cobró la indemnización por despido arbitrario o no cobró la indemnización por otro concepto con el mismo fin (por ejemplo incentivos) entonces procede el amparo').

%->Grupo NÂº4 (Despido Injustificado) uno solo
regla('ReglaPorInjustificado','Si es Injustificado').
   regla('ReglaPorInjustificado1','Si solicita la reposición al trabajo y en la vía ordinaria no es posible obtener la reposición o la restitución del derecho vulnerado procede el amparo').
   regla('ReglaPorInjustificado2','Si es urgente procede el amparo').
   regla('ReglaPorInjustificado3','Si demuestra objetivamente y fehacientemente que la vía laboral ordinaria no es la idónea procede el amparo').
   regla('ReglaPorInjustificado4','Si no cobró la indemnización por despido arbitrario o no cobró la indemnización por otro concepto con el mismo fin (por ejemplo incentivos) entonces procede el amparo').
   regla('ReglaPorInjustificado5','Si no hay controversia o no hay duda en los hechos procede el amparo').
                   
%-----Regimen Laboral Publico-----
%->Grupo NÂº1(*) uno solo
regla('ReglaPorPublico','Si es del Regimen Público').
   regla('ReglaPorPublico1','Si es urgente procede el amparo').
   regla('ReglaPorPublico2','Si demuestra objetivamente y fehacientemente que la vía contenciosa administrativa no es la idónea procede el amparo').
   regla('ReglaPorPublico3','Si es despedido por afiliarse a un sindicato procede el amparo').
   regla('ReglaPorPublico4','Si es despedido por desempeño de cargo sindical procede el amparo').
   regla('ReglaPorPublico5','Si es despedido porque está embarazada procede el amparo').
   regla('ReglaPorPublico6','Si es despedido porque es impedido físico o mental procede el amparo').
%**************************************************

%*********Resultados Correctos de Reglas para Criterios***********
reglaEsCorrecta('ReglaPorFraudulento'):-resH('F',R1),(R1 = si),(reglaEsCorrecta('ReglaPorFraudulento6'),(reglaEsCorrecta('ReglaPorFraudulento5'),(reglaEsCorrecta('ReglaPorFraudulento1');reglaEsCorrecta('ReglaPorFraudulento2');reglaEsCorrecta('ReglaPorFraudulento3');reglaEsCorrecta('ReglaPorFraudulento4')))),!.
reglaEsCorrecta('ReglaPorFraudulento1'):-resH('F1',R1),resH('F1.1',R2),resH('F1.2',R3),(R1 = si,(R2 = si;R3 = si)),!.
reglaEsCorrecta('ReglaPorFraudulento2'):-resH('F2',R1),resH('F3',R2),(R1 = si,R2 = si),!.
reglaEsCorrecta('ReglaPorFraudulento3'):-resH('F4',R1),(R1 = si),!.
reglaEsCorrecta('ReglaPorFraudulento4'):-resH('F5',R1),resH('F6',R2),(R1 = si,R2 = si),!.
reglaEsCorrecta('ReglaPorFraudulento5'):-resH('F7',R1),resH('F8',R2),not(R1 = si;R2 = si),!.
reglaEsCorrecta('ReglaPorFraudulento6'):-resH('F9',R1),resH('F10',R2),not(R1 = si;R2 = si),!. %Resulta No

reglaEsCorrecta('ReglaPorNulo'):-resH('N',R1),(R1 = si),(reglaEsCorrecta('ReglaPorNulo1');reglaEsCorrecta('ReglaPorNulo2');reglaEsCorrecta('ReglaPorNulo3');reglaEsCorrecta('ReglaPorNulo4')),!.

reglaEsCorrecta('ReglaPorNulo1'):-resH('N1',R1),(R1 = si),(reglaEsCorrecta('ReglaPorNulo1.1');reglaEsCorrecta('ReglaPorNulo1.2');reglaEsCorrecta('ReglaPorNulo1.3');reglaEsCorrecta('ReglaPorNulo1.4');reglaEsCorrecta('ReglaPorNulo1.5')),!.
reglaEsCorrecta('ReglaPorNulo1.1'):-resH('N1.1',R1),(R1 = si),!.
reglaEsCorrecta('ReglaPorNulo1.2'):-resH('N1.2',R1),(R1 = si),!.
reglaEsCorrecta('ReglaPorNulo1.3'):-resH('N1.3',R1),(R1 = si),!.
reglaEsCorrecta('ReglaPorNulo1.4'):-resH('N1.4',R1),(R1 = si),!.
reglaEsCorrecta('ReglaPorNulo1.5'):-resH('N1.5',R1),(R1 = si),!.

reglaEsCorrecta('ReglaPorNulo2'):-resH('N2',R1),(reglaEsCorrecta('ReglaPorNulo2.1')),(R1 = si),!.
reglaEsCorrecta('ReglaPorNulo2.1'):-resH('N2.1',R1),resH('N2.2',R2),resH('N2.3',R3),resH('N2.4',R4),resH('N2.5',R5),resH('N2.6',R6),((R1 = si);(R2 = si);(R3 = si);(R4 = si);(R5 = si);(R6 = si)),!.

reglaEsCorrecta('ReglaPorNulo3'):-resH('N3',R1),(reglaEsCorrecta('ReglaPorNulo3.1');reglaEsCorrecta('ReglaPorNulo3.2')),(R1 = si),!.
reglaEsCorrecta('ReglaPorNulo3.1'):-resH('N3.1',R1),resH('N3.2',R2),resH('N3.3',R3),resH('N3.4',R4),(R1 = si,R2 = si,R3 = si,R4 = no),!.
reglaEsCorrecta('ReglaPorNulo3.2'):-resH('N3.1',R1),resH('N3.2',R2),resH('N3.3',R3),resH('N3.4',R4),(R1 = si,R2 = no,R3 = si,R4 = si),!.

reglaEsCorrecta('ReglaPorNulo4'):-resH('N4',R1),(reglaEsCorrecta('ReglaPorNulo4.1')),(R1 = si),!.
reglaEsCorrecta('ReglaPorNulo4.1'):-resH('N4.1',R1),resH('N4.2',R2),((R1 = si);(R2 = si)),!.

reglaEsCorrecta('ReglaPorIncausado'):-resH('IC',R1),(R1 = si),(reglaEsCorrecta('ReglaPorIncausado8'),(reglaEsCorrecta('ReglaPorIncausado7'),(reglaEsCorrecta('ReglaPorIncausado1');reglaEsCorrecta('ReglaPorIncausado2');reglaEsCorrecta('ReglaPorIncausado3');reglaEsCorrecta('ReglaPorIncausado4');reglaEsCorrecta('ReglaPorIncausado5');reglaEsCorrecta('ReglaPorIncausado6')))),!.
reglaEsCorrecta('ReglaPorIncausado1'):-resH('IC1',R1),resH('IC1.1',R2),resH('IC1.2',R3),((R1 = si),((R2 = si);(R3 = si))),!.
reglaEsCorrecta('ReglaPorIncausado2'):-resH('IC2',R1),resH('IC3',R2),((R1 = si),(R2 = si)),!.
reglaEsCorrecta('ReglaPorIncausado3'):-resH('IC4',R1),resH('IC5',R2),((R1 = si),(R2 = si)),!.
reglaEsCorrecta('ReglaPorIncausado4'):-resH('IC6',R1),resH('IC7',R2),((R1 = si),(R2 = si)),!.
reglaEsCorrecta('ReglaPorIncausado5'):-resH('IC8',R1),(R1 = si),!.
reglaEsCorrecta('ReglaPorIncausado6'):-resH('IC9',R1),resH('IC10',R2),((R1 = si),(R2 = si)),!.
reglaEsCorrecta('ReglaPorIncausado7'):-resH('IC11',R1),resH('IC12',R2),not(R1 = si;R2 = si),!.    %Resulta No
reglaEsCorrecta('ReglaPorIncausado8'):-resH('IC13',R1),resH('IC14',R2),not(R1 = si;R2 = si),!. %Resulta No

reglaEsCorrecta('ReglaPorInjustificado'):-resH('IJ',R1),(R1 = si),(reglaEsCorrecta('ReglaPorInjustificado4'),(reglaEsCorrecta('ReglaPorInjustificado5'),(reglaEsCorrecta('ReglaPorInjustificado1');reglaEsCorrecta('ReglaPorInjustificado2');reglaEsCorrecta('ReglaPorInjustificado3')))),!.
reglaEsCorrecta('ReglaPorInjustificado1'):-resH('IJ1',R1),resH('IJ1.1',R2),resH('IJ1.2',R3),((R1 = si),((R2 = si);(R3 = si))),!.
reglaEsCorrecta('ReglaPorInjustificado2'):-resH('IJ2',R1),(R1 = si),!.
reglaEsCorrecta('ReglaPorInjustificado3'):-resH('IJ3',R1),resH('IJ4',R2),((R1 = si),(R2 = si)),!.
reglaEsCorrecta('ReglaPorInjustificado4'):-resH('IJ5',R1),resH('IJ6',R2),not(R1 = si ; R2 = si),!. %Resulta No
reglaEsCorrecta('ReglaPorInjustificado5'):-resH('IJ7',R1),resH('IJ8',R2),not(R1 = si ; R2 = si),!. %Resulta No

reglaEsCorrecta('ReglaPorPublico'):-resH('P',R1),(R1 = si),(reglaEsCorrecta('ReglaPorPublico1');reglaEsCorrecta('ReglaPorPublico2');reglaEsCorrecta('ReglaPorPublico3');reglaEsCorrecta('ReglaPorPublico4');reglaEsCorrecta('ReglaPorPublico5');reglaEsCorrecta('ReglaPorPublico6')),!.
reglaEsCorrecta('ReglaPorPublico1'):-resH('P1',R1),(R1 = si),!.
reglaEsCorrecta('ReglaPorPublico2'):-resH('P2',R1),resH('P3',R2),((R1 = si),(R2 = si)),!.
reglaEsCorrecta('ReglaPorPublico3'):-resH('P4',R1),(R1 = si),!.
reglaEsCorrecta('ReglaPorPublico4'):-resH('P5',R1),(R1 = si),!.
reglaEsCorrecta('ReglaPorPublico5'):-resH('P6',R1),(R1 = si),!.
reglaEsCorrecta('ReglaPorPublico6'):-resH('P7',R1),resH('P8',R2),((R1 = si);(R2 = si)),!.
%***************************************************

%*********Resultados Correctos de Reglas para Requisitos***********
reglaEsCorrecta('ReglaPorRequisito'):-resH('Requ',R1),(R1 = si),(reglaEsCorrecta('ReglaPorRequisito1'),reglaEsCorrecta('ReglaPorRequisito2'),reglaEsCorrecta('ReglaPorRequisito3'),reglaEsCorrecta('ReglaPorRequisito4'),reglaEsCorrecta('ReglaPorRequisito5'),reglaEsCorrecta('ReglaPorRequisito6'),reglaEsCorrecta('ReglaPorRequisito7'),(reglaEsCorrecta('ReglaPorRequisito8');reglaEsCorrecta('ReglaPorRequisito10.1');reglaEsCorrecta('ReglaPorRequisito11')),reglaEsCorrecta('ReglaPorRequisito12'),reglaEsCorrecta('ReglaPorRequisito13'),reglaEsCorrecta('ReglaPorRequisito14')),!.

reglaEsCorrecta('ReglaPorRequisito1'):-reglaEsCorrecta('ReglaPorRequisito1.1'),!.
reglaEsCorrecta('ReglaPorRequisito1.1'):-resH('Requ1.0',R1),not(R1 = si),!.   %RESULTA NO

reglaEsCorrecta('ReglaPorRequisito2'):-resH('Requ2.0',R1),not(R1 = si),!.   %RESULTA NO

reglaEsCorrecta('ReglaPorRequisito3'):-(reglaEsCorrecta('ReglaPorRequisito3.1')),!.
reglaEsCorrecta('ReglaPorRequisito3.1'):-resH('Requ3.0',R1),resH('Requ3.1',R2),resH('Requ3.2',R3),(not(R1 = si),not(R2 = si),not(R3 = si)),!.

reglaEsCorrecta('ReglaPorRequisito4'):-(reglaEsCorrecta('ReglaPorRequisito4.1')),!.  %resulta no
reglaEsCorrecta('ReglaPorRequisito4.1'):-resH('Requ6.0',R1),not(R1 = si),!.  %resulta No

reglaEsCorrecta('ReglaPorRequisito5'):-resH('Requ7.0',R1),not(R1 = si),!.

reglaEsCorrecta('ReglaPorRequisito6'):-resH('Requ8.0',R1),not(R1 = si),!.

reglaEsCorrecta('ReglaPorRequisito7'):-resH('Requ9.0',R1),not(R1 = si),!.

reglaEsCorrecta('ReglaPorRequisito8'):-resH('Requ10.0',R1),not(R1 = si);(reglaEsCorrecta('ReglaPorRequisito8.1');reglaEsCorrecta('ReglaPorRequisito8.2')),!.
reglaEsCorrecta('ReglaPorRequisito8.1'):-resH('Requ10.1',R1),resH('Requ10.2',R2),(R1 = si),(R2 = no),!.   %RESULTA NO
reglaEsCorrecta('ReglaPorRequisito8.2'):-resH('Requ10.1',R1),resH('Requ10.2',R2),(R1 = no),(R2 = no),!.    %RESULTA NO

reglaEsCorrecta('ReglaPorRequisito10.1'):-resH('Requ10.3',R1),(R1 = si),!. %no es sub de 10

reglaEsCorrecta('ReglaPorRequisito11'):-(reglaEsCorrecta('ReglaPorRequisito11.1')),!.
reglaEsCorrecta('ReglaPorRequisito11.1'):-resH('Requ11.0',R1),not(R1 = no),!. %Resulta NO

reglaEsCorrecta('ReglaPorRequisito12'):-resH('Requ12.0',R1),not(R1 = si),!.      %RESULTA NO

reglaEsCorrecta('ReglaPorRequisito13'):-resH('Requ13.0',R1),not(R1 = si),!.      %RESULTA NO

reglaEsCorrecta('ReglaPorRequisito14'):-resH('Requ14.0',R1),not(R1 = si),!.
%***************************************************

%***************Modulo de Explicacion***************
explicaSi('ReglaPorFraudulento',X):-
(not(reglaEsCorrecta('ReglaPorFraudulento6')),regla('ReglaPorFraudulento6',X));
((reglaEsCorrecta('ReglaPorFraudulento1'),regla('ReglaPorFraudulento1',X));
(reglaEsCorrecta('ReglaPorFraudulento2'),regla('ReglaPorFraudulento2',X));
(reglaEsCorrecta('ReglaPorFraudulento3'),regla('ReglaPorFraudulento3',X));
(reglaEsCorrecta('ReglaPorFraudulento4'),regla('ReglaPorFraudulento4',X));
(reglaEsCorrecta('ReglaPorFraudulento5'),regla('ReglaPorFraudulento5',X))).
explicaSi('ReglaPorNulo',X):-(
((reglaEsCorrecta('ReglaPorNulo1'),regla('ReglaPorNulo1',X));((reglaEsCorrecta('ReglaPorNulo1.1'),regla('ReglaPorNulo1.1',X));(reglaEsCorrecta('ReglaPorNulo1.2'),regla('ReglaPorNulo1.2',X));(reglaEsCorrecta('ReglaPorNulo1.3'),regla('ReglaPorNulo1.3',X));(reglaEsCorrecta('ReglaPorNulo1.4'),regla('ReglaPorNulo1.4',X));(reglaEsCorrecta('ReglaPorNulo1.5'),regla('ReglaPorNulo1.5',X))));
((reglaEsCorrecta('ReglaPorNulo2'),regla('ReglaPorNulo2',X));(reglaEsCorrecta('ReglaPorNulo2.1'),regla('ReglaPorNulo2.1',X)));
((reglaEsCorrecta('ReglaPorNulo3'),regla('ReglaPorNulo3',X));((reglaEsCorrecta('ReglaPorNulo3.1'),regla('ReglaPorNulo3.1',X));(reglaEsCorrecta('ReglaPorNulo3.2'),regla('ReglaPorNulo3.2',X))));
((reglaEsCorrecta('ReglaPorNulo4'),regla('ReglaPorNulo4',X));(reglaEsCorrecta('ReglaPorNulo4.1'),regla('ReglaPorNulo4.1',X)))).
explicaSi('ReglaPorIncausado',X):-
(not(reglaEsCorrecta('ReglaPorIncausado8')),regla('ReglaPorIncausado8',X));(
(reglaEsCorrecta('ReglaPorIncausado1'),regla('ReglaPorIncausado1',X));
(reglaEsCorrecta('ReglaPorIncausado2'),regla('ReglaPorIncausado2',X));
(reglaEsCorrecta('ReglaPorIncausado3'),regla('ReglaPorIncausado3',X));
(reglaEsCorrecta('ReglaPorIncausado4'),regla('ReglaPorIncausado4',X));
(reglaEsCorrecta('ReglaPorIncausado5'),regla('ReglaPorIncausado5',X));
(reglaEsCorrecta('ReglaPorIncausado6'),regla('ReglaPorIncausado6',X));
(reglaEsCorrecta('ReglaPorIncausado7'),regla('ReglaPorIncausado7',X))).
explicaSi('ReglaPorInjustificado',X):-
(not(reglaEsCorrecta('ReglaPorInjustificado4')),regla('ReglaPorInjustificado4',X));(
(reglaEsCorrecta('ReglaPorInjustificado5'),regla('ReglaPorInjustificado5',X));
(reglaEsCorrecta('ReglaPorInjustificado1'),regla('ReglaPorInjustificado1',X));
(reglaEsCorrecta('ReglaPorInjustificado2'),regla('ReglaPorInjustificado2',X));
(reglaEsCorrecta('ReglaPorInjustificado3'),regla('ReglaPorInjustificado3',X))).
explicaSi('ReglaPorPublico',X):-
(reglaEsCorrecta('ReglaPorPublico1'),regla('ReglaPorPublico1',X));
(reglaEsCorrecta('ReglaPorPublico2'),regla('ReglaPorPublico2',X));
(reglaEsCorrecta('ReglaPorPublico3'),regla('ReglaPorPublico3',X));
(reglaEsCorrecta('ReglaPorPublico4'),regla('ReglaPorPublico4',X));
(reglaEsCorrecta('ReglaPorPublico5'),regla('ReglaPorPublico5',X));
(reglaEsCorrecta('ReglaPorPublico6'),regla('ReglaPorPublico6',X)).


explicaNo('ReglaPorFraudulento',X):-
(not(reglaEsCorrecta('ReglaPorFraudulento6')),regla('ReglaPorFraudulento6',X)),!;
((not(reglaEsCorrecta('ReglaPorFraudulento1')),regla('ReglaPorFraudulento1',X));
(not(reglaEsCorrecta('ReglaPorFraudulento2')),regla('ReglaPorFraudulento2',X));
(not(reglaEsCorrecta('ReglaPorFraudulento3')),regla('ReglaPorFraudulento3',X));
(not(reglaEsCorrecta('ReglaPorFraudulento4')),regla('ReglaPorFraudulento4',X));
(not(reglaEsCorrecta('ReglaPorFraudulento5')),regla('ReglaPorFraudulento5',X))).
explicaNo('ReglaPorNulo',X):-
%((not(reglaEsCorrecta('ReglaPorNulo1')),regla('ReglaPorNulo1',X));((not(reglaEsCorrecta('ReglaPorNulo1.1')),regla('ReglaPorNulo1.1',X));(not(reglaEsCorrecta('ReglaPorNulo1.2')),regla('ReglaPorNulo1.2',X));(not(reglaEsCorrecta('ReglaPorNulo1.3')),regla('ReglaPorNulo1.3',X));(not(reglaEsCorrecta('ReglaPorNulo1.4')),regla('ReglaPorNulo1.4',X));(not(reglaEsCorrecta('ReglaPorNulo1.5')),regla('ReglaPorNulo1.5',X)))),!;
%((not(reglaEsCorrecta('ReglaPorNulo2')),regla('ReglaPorNulo2',X));(not(reglaEsCorrecta('ReglaPorNulo2.1')),regla('ReglaPorNulo2.1',X))),!;
regla('ReglaPorNulo3',X);((not(reglaEsCorrecta('ReglaPorNulo3.1')),regla('ReglaPorNulo3.1',X));(not(reglaEsCorrecta('ReglaPorNulo3.2')),regla('ReglaPorNulo3.2',X))).
%((not(reglaEsCorrecta('ReglaPorNulo4')),regla('ReglaPorNulo4',X));(not(reglaEsCorrecta('ReglaPorNulo4.1')),regla('ReglaPorNulo4.1',X)))),!.

explicaNo('ReglaPorIncausado',X):-
(not(reglaEsCorrecta('ReglaPorIncausado8')),regla('ReglaPorIncausado8',X)),!;(
(not(reglaEsCorrecta('ReglaPorIncausado1')),regla('ReglaPorIncausado1',X));
(not(reglaEsCorrecta('ReglaPorIncausado2')),regla('ReglaPorIncausado2',X));
(not(reglaEsCorrecta('ReglaPorIncausado3')),regla('ReglaPorIncausado3',X));
(not(reglaEsCorrecta('ReglaPorIncausado4')),regla('ReglaPorIncausado4',X));
(not(reglaEsCorrecta('ReglaPorIncausado5')),regla('ReglaPorIncausado5',X));
(not(reglaEsCorrecta('ReglaPorIncausado6')),regla('ReglaPorIncausado6',X));
(not(reglaEsCorrecta('ReglaPorIncausado7')),regla('ReglaPorIncausado7',X))).
explicaNo('ReglaPorInjustificado',X):-
(not(reglaEsCorrecta('ReglaPorInjustificado4')),regla('ReglaPorInjustificado4',X)),!;(
(not(reglaEsCorrecta('ReglaPorInjustificado5')),regla('ReglaPorInjustificado5',X));
(not(reglaEsCorrecta('ReglaPorInjustificado1')),regla('ReglaPorInjustificado1',X));
(not(reglaEsCorrecta('ReglaPorInjustificado2')),regla('ReglaPorInjustificado2',X));
(not(reglaEsCorrecta('ReglaPorInjustificado3')),regla('ReglaPorInjustificado3',X))).
explicaNo('ReglaPorPublico',X):-
(not(reglaEsCorrecta('ReglaPorPublico1')),regla('ReglaPorPublico1',X));
(not(reglaEsCorrecta('ReglaPorPublico2')),regla('ReglaPorPublico2',X));
(not(reglaEsCorrecta('ReglaPorPublico3')),regla('ReglaPorPublico3',X));
(not(reglaEsCorrecta('ReglaPorPublico4')),regla('ReglaPorPublico4',X));
(not(reglaEsCorrecta('ReglaPorPublico5')),regla('ReglaPorPublico5',X));
(not(reglaEsCorrecta('ReglaPorPublico6')),regla('ReglaPorPublico6',X)).
%***************************************************
%***************Checks o Radios Input***************
resH('input',si).
%**************************************************
