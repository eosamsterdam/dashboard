
file "resources/public/js/compiled/app.js" => FileList["src/**.cljs"] do
  sh %[lein clean]
  sh %[lein cljsbuild once min]
end

task :build => "resources/public/js/compiled/app.js"

task :commit => :build do
   sh %[git add --all resources]
   sh %[git commit -m "gh-pages build commit"]
end

task :ship => :commit do
   sh %[git subtree push --prefix resources/public origin gh-pages]
end

task :open do
  sh %[open "https://eosamsterdam.github.io/website/#/"]
end

task :deploy => :ship
