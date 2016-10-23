from pprint import pprint

with open('ref_index.html', encoding='UTF-8') as cf:
	page = cf.read();

with open('../README.md', encoding='UTF-8') as rd:
	readme = rd.read();

page = page.format(README=readme)

with open('/www/index.html', 'w', encoding='UTF-8') as output:
	output.write(page)
