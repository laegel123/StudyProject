FROM debian
LABEL authors="laegel <laegel1@gmail.com>"

COPY webpage.sh /
RUN apt-get update && apt-get install fortune

CMD ["/htdocs/webpage.sh"]
