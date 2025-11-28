(ns projeto-entrevista.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(defroutes app
  (GET "/" []
       "<!DOCTYPE html>
        <html lang='pt-BR'>
        <head>
          <meta charset='UTF-8' />
          <title>Olá CSD BR!</title>
          <style>
            body {
              font-family: Arial, sans-serif;
              background: #f5f7fa;
              display: flex;
              align-items: center;
              justify-content: center;
              height: 100vh;
              margin: 0;
            }
            .container {
              background: white;
              padding: 40px;
              border-radius: 12px;
              box-shadow: 0 4px 20px rgba(0,0,0,0.1);
              max-width: 500px;
              text-align: center;
            }
            h1 {
              color: #333;
              margin-bottom: 10px;
            }
            p {
              color: #555;
              line-height: 1.5;
              font-size: 18px;
              margin-top: 0;
            }
            .footer {
              margin-top: 25px;
              font-size: 14px;
              color: #888;
            }
          </style>
        </head>
        <body>
          <div class='container'>
            <h1>Olá, CSD BR! 👋</h1>
            <p>Feito em <strong>Clojure</strong> porque meu código também gosta de ser funcional - assim como eu na CSD BR XD</p>
            <p>Acesse o github com o código desse site clicando <a href='https://github.com/thalles-guimaraes/entrevista-csd/'>AQUI</a></p>
            <div class='footer'>Desenvolvido especialmente para esta entrevista.</div>
          </div>
        </body>
        </html>")
  (route/not-found "404 - Página não encontrada"))

(defn -main []
  (run-jetty app {:port (Integer/parseInt (or (System/getenv "PORT") "8080"))
                  :join? false}))
