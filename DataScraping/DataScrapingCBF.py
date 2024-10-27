import requests
import pandas as pd
from bs4 import BeautifulSoup
from openpyxl.workbook import Workbook

def lista_temporada(url_serie):
  url_base = url_serie
  req = requests.get(url_base)


  soup = BeautifulSoup(req.text, 'html.parser')
  lista_temporada_anos = []


  for a in soup.find_all('option'):
    lista_temporada_anos.append(url_base+a.get_text('Value'))
  
  return sorted(lista_temporada_anos)

def lista_link_jogo(link_temporada):
  url_base = link_temporada
  req = requests.get(url_base)


  soup = BeautifulSoup(req.text, 'html.parser')
  lista_link_jogo = []


  link_jogo = soup.find_all(class_ ='btn btn-xs btn-success m-t-5')
  for link in link_jogo:
    lista_link_jogo.append(link['href'])


  return lista_link_jogo

def busca_dado_partida(link_partida):
  req = requests.get(link_partida)


  soup = BeautifulSoup(req.text, 'html.parser')


  serie = soup.find(class_ = 'color-white block').text.split('-')[1].strip().split(' ')[1]
  estadio = soup.find_all(class_ = 'text-2 p-r-20')[0].text.split('-')[0].strip() 
  cidade = soup.find_all(class_ = 'text-2 p-r-20')[0].text.split('-')[1].strip()
  estado = soup.find_all(class_ = 'text-2 p-r-20')[0].text.split('-')[2].strip()
  mes = soup.find_all(class_ = 'text-2 p-r-20')[1].text.split(',')[1].strip().split('de')[1]
  ano = int(soup.find_all(class_ = 'text-2 p-r-20')[1].text.split(',')[1].strip().split('de')[2]) 
  mandante = soup.find_all(class_ = 'time-nome color-white')[0].text.strip()
  visitante = soup.find_all(class_ = 'time-nome color-white')[1].text.strip() 
  gol_mandante = int(soup.find_all(class_ = 'time-gols block')[0].text.strip())
  gol_visitante = int(soup.find_all(class_ = 'time-gols block')[1].text.strip())


  if gol_mandante > gol_visitante:
    vitoria_mandante = 1
    vitoria_visitante = 0
    jogo_empatado = 0
    ponto_mandante = 3
    ponto_visitante = 0
  if gol_mandante < gol_visitante:
    vitoria_mandante = 0
    vitoria_visitante = 1
    jogo_empatado = 0
    ponto_mandante = 0
    ponto_visitante = 3
  if gol_mandante == gol_visitante:
    vitoria_mandante = 0
    vitoria_visitante = 0
    jogo_empatado = 1
    ponto_mandante = 1
    ponto_visitante = 1


  # Cria um dicionario para estruturar os dados
  partida = {
      'serie' : serie,
      'estadio' : estadio,
      'cidade' : cidade,
      'estado' : estado,
      'mes' : mes,
      'ano' : ano,
      'mandante' : mandante,
      'visitante' : visitante,
      'gol_mandante' : gol_mandante,
      'gol_visitante' : gol_visitante,
      'vitoria_mandante' : vitoria_mandante,
      'vitoria_visitante' : vitoria_visitante,
      'jogo_empatado' : jogo_empatado,
      'ponto_mandante' : ponto_mandante,
      'ponto_visitante' : ponto_visitante
  }
  return(partida)


url_serie = 'https://www.cbf.com.br/futebol-brasileiro/competicoes/campeonato-brasileiro-serie-a/'
dados = []

for link_temporada in lista_temporada(url_serie):
  print(link_temporada)
  for link_partida in lista_link_jogo(link_temporada):
    print(busca_dado_partida(link_partida))
    dados.append(busca_dado_partida(link_partida))


#Salva os dados em um arquivo xlsx
df = pd.DataFrame.from_dict(dados)
df.to_excel('Dados Serie A.xlsx')

