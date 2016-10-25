#!/usr/bin/python3.5
from pprint import pprint

projectdir = '/home/tester/Tic-Tac-Toe'
webpath = '/www'

with open('{project}/bin/ref_index.html'.format(project=projectdir), encoding='UTF-8') as cf:
	page = cf.read();

with open('{project}/README.md'.format(project=projectdir), encoding='UTF-8') as rd:
	readme = rd.read();

page = page.format(README=readme)

with open('{web}/index.html'.format(web=webpath), 'w', encoding='UTF-8') as output:
	output.write(page)
