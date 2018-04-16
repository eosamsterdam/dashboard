
file "resources/public/js/compiled/app.js" => FileList["src/**.cljs"] do
  sh %[lein clean]
  sh %[lein cljsbuild once min]
end

task :build => "resources/public/js/compiled/app.js"

task :commit => :build do
   sh %[git add --all resources]
   sh %[git commit -m "gh-pages build commit" || true]
end

# http://clontz.org/blog/2014/05/08/git-subtree-push-for-deployment/
task :ship => :commit do
   #sh %[git subtree push --prefix resources/public origin gh-pages]
   sh %[git push origin `git subtree split --prefix resources/public master`:gh-pages --force]
end

task :open do
  sh %[open "https://eosamsterdam.github.io/website/#/"]
end

task :deploy => :ship
