(ns parser)

(defn parser
  "Parser SVG text"
  [csv-text]
  (->>
   (re-seq #"\"([^\"]*)\"|(?<=,|^)([^,]*)(?:,|$)" csv-text)
   (map #(first %))))