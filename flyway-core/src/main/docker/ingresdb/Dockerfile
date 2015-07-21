FROM spind42/ingres

RUN echo "ingres" | passwd --stdin ingres

RUN su -c "createdb ingresdb" ingres

CMD["/usr/bin/supervisord"]

