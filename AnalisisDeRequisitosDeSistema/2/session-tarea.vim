let SessionLoad = 1
let s:so_save = &so | let s:siso_save = &siso | set so=0 siso=0
let v:this_session=expand("<sfile>:p")
silent only
cd ~\Universidad\AnalisisDeRequisitosDeSistema\2
if expand('%') == '' && !&modified && line('$') <= 1 && getline(1) == ''
  let s:wipebuf = bufnr('%')
endif
set shortmess=aoO
badd +1 ~\Universidad\FundamentosDeLaContruccionDeSoftware\Tareas\Unidad2\actividad3-ers.md
badd +1 tarea.md
badd +1 ~\Universidad\FundamentosDeLaContruccionDeSoftware\Tareas\Unidad2\biblio.bibtex
argglobal
%argdel
set stal=2
edit ~\Universidad\FundamentosDeLaContruccionDeSoftware\Tareas\Unidad2\actividad3-ers.md
set splitbelow splitright
wincmd _ | wincmd |
vsplit
1wincmd h
wincmd w
set nosplitbelow
set nosplitright
wincmd t
set winminheight=0
set winheight=1
set winminwidth=0
set winwidth=1
exe 'vert 1resize ' . ((&columns * 136 + 137) / 274)
exe 'vert 2resize ' . ((&columns * 137 + 137) / 274)
argglobal
setlocal fdm=expr
setlocal fde=pandoc#folding#FoldExpr()
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=3
setlocal fml=1
setlocal fdn=20
setlocal fen
let s:l = 68 - ((63 * winheight(0) + 33) / 66)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
68
normal! 0
wincmd w
argglobal
if bufexists("~\Universidad\FundamentosDeLaContruccionDeSoftware\Tareas\Unidad2\biblio.bibtex") | buffer ~\Universidad\FundamentosDeLaContruccionDeSoftware\Tareas\Unidad2\biblio.bibtex | else | edit ~\Universidad\FundamentosDeLaContruccionDeSoftware\Tareas\Unidad2\biblio.bibtex | endif
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
silent! normal! zE
let s:l = 1 - ((0 * winheight(0) + 33) / 66)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
1
normal! 0
wincmd w
exe 'vert 1resize ' . ((&columns * 136 + 137) / 274)
exe 'vert 2resize ' . ((&columns * 137 + 137) / 274)
tabedit tarea.md
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winminheight=0
set winheight=1
set winminwidth=0
set winwidth=1
argglobal
setlocal fdm=expr
setlocal fde=pandoc#folding#FoldExpr()
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=3
setlocal fml=1
setlocal fdn=20
setlocal fen
let s:l = 120 - ((55 * winheight(0) + 33) / 66)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
120
normal! 0
tabnext 2
set stal=1
if exists('s:wipebuf') && getbufvar(s:wipebuf, '&buftype') isnot# 'terminal'
  silent exe 'bwipe ' . s:wipebuf
endif
unlet! s:wipebuf
set winheight=1 winwidth=20 winminheight=1 winminwidth=1 shortmess=filnxtToOFcI
let s:sx = expand("<sfile>:p:r")."x.vim"
if file_readable(s:sx)
  exe "source " . fnameescape(s:sx)
endif
let &so = s:so_save | let &siso = s:siso_save
doautoall SessionLoadPost
unlet SessionLoad
" vim: set ft=vim :
