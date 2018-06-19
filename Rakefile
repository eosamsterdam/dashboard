
file "resources/public/js/compiled/app.js" => FileList["project.clj", "src/**.cljs"] do
  sh %[lein clean]
  sh %[lein do cljsbuild once min, less once]
end

task :build => "resources/public/js/compiled/app.js"

task :commit => :build do
   sh %[git add --all resources]
   sh %[git commit -m "gh-pages build commit" || true]
end

# http://clontz.org/blog/2014/05/08/git-subtree-push-for-deployment/
task :ship => :commit do
   sh %[git push origin `git subtree split --prefix resources/public master`:gh-pages --force]
end

task :open do
  sh %[open "https://explorer.eosamsterdam.net/#/"]
end

task :deploy => :ship
