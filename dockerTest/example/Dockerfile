FROM debian
LABEL authors="laegel <laegel1@gmail.com>"

COPY webpage.sh /webpage.sh
RUN apt-get -y update
RUN apt-get install -y fortune

CMD [".webpage.sh"]
