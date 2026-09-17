<div align="center">

# 🏛️ VirasatSetu
### Bridging Eras, Preserving India's Living Heritage

**An AI-Powered Digital Preservation, Exploration & Revival Platform**

*Preserve the Past. Experience the Present. Inspire the Future.*

<p>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white"/>
  <img src="https://img.shields.io/badge/Groq_AI-F55036?style=for-the-badge&logo=probot&logoColor=white"/>
</p>

<p>
  <img src="https://img.shields.io/badge/Status-Active-2EC4B6?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/AICTE-Problem_Statement_26197-6A0DAD?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/License-MIT-blue?style=for-the-badge"/>
</p>

<p>
  <a href="https://virasatsetu-phi.vercel.app/"><img src="https://img.shields.io/badge/🔗_Live_Demo-View_Site-2EC4B6?style=for-the-badge"/></a>
  <a href="https://github.com/shivkoli07/virasatsetu"><img src="https://img.shields.io/badge/GitHub-Repository-181717?style=for-the-badge&logo=github&logoColor=white"/></a>
</p>

</div>

---

## 📖 About the Project

Modernization, urbanization, and the loss of elder master practitioners are erasing India's regional dialects, art forms, and indigenous knowledge systems at an irreversible pace. Today, only an estimated **12%** of India's intangible heritage has structured digital records, and many traditions survive with **fewer than 25 living master practitioners**.

**VirasatSetu** unifies digital documentation, immersive teaching, and community-driven revival into a single AI-powered ecosystem — the **first of its kind** for India's living intangible heritage, built for **AICTE Problem Statement 26197**.

> No unified, AI-powered platform currently exists for living heritage discovery and revival in India. VirasatSetu closes that gap with a four-pillar ecosystem where every module feeds signal into the others — exploration drives storytelling, storytelling surfaces risk scores, risk scores motivate game-based learning, and games generate new community contributors.

---

## ✨ Four-Pillar Ecosystem

<table>
<tr>
<td width="25%" align="center" valign="top">

### 🗺️ Explore
16 heritage domains, 160+ case studies with geo-coordinates, high-res imagery, historical dossiers, and master-practitioner lineage documentation.

</td>
<td width="25%" align="center" valign="top">

### 🧭 Experience
Leaflet.js GIS map of 20 verified heritage sites, an AI Storyteller, a dual Gregorian/Vikram-Samvat festival calendar, and 360° tours of six sacred sites.

</td>
<td width="25%" align="center" valign="top">

### 📊 Analytics
Live-mic oral-testimony ingestion pipeline and a **Heritage Risk Engine** scoring traditions as Critical / Vulnerable / Declining / Thriving.

</td>
<td width="25%" align="center" valign="top">

### 🎮 Games
8 culturally-named gaming trials with an XP + badge system, turning passive heritage consumption into active, gamified learning.

</td>
</tr>
</table>

---

## 🔍 Module Deep-Dive

### 1️⃣ Explore — Encyclopedic Living Taxonomy
- 16 structured domains × 10 case studies each (**160+ documented traditions**)
- Every case study: high-res imagery, historical dossier, Google Maps coordinates, practitioner profiles & lineage documentation
- Authentic typography system — Cinzel, Playfair Display, Plus Jakarta Sans

### 2️⃣ Experience — Immersive Engines & GIS Mapping
- **Living Heritage GIS Map** — Leaflet.js v1.9.4, 20 verified sites, category filters, `flyTo` camera pan, geo-dossier sidebar
- **AI Heritage Storyteller** — Groq-powered narrative generation by dynasty/theme/tone, with Web Speech synthesis (en-IN voice)
- **Festival Calendar & Panchangam** — dual Gregorian + Vikram Samvat/Shaka dating, 50+ festivals with ritual & cuisine dossiers
- **360° Virtual Tours** — Ellora, Brihadisvara, Konark, Hampi, Ajanta, Rani ki Vav (Fullscreen API)

### 3️⃣ Analytics — Preservation Engine & Oral Archive
- Live mic recording with real-time canvas waveform visualization — a direct elder-testimony capture pipeline
- **Heritage Risk Engine** — scores traditions on surviving masters, youth adoption, documentation completeness & economic viability
- Community dashboard with filterable vulnerability table and "Record"/"Sponsor" actions

### 4️⃣ Virasat AI — RAG-Powered Conversational Intelligence
- Groq-powered chat with a system persona that routes users to the right module and returns cited, Markdown-table answers
- **Automatic model fallback chain** for zero-downtime resilience:
  `openai/gpt-oss-120b` → `openai/gpt-oss-20b` → `qwen3.6-27b`
- Multilingual support via Google Translate — Hindi, Tamil, Telugu, Kannada, Malayalam

### 5️⃣ Sacred Cultural Gaming Pavilion
| # | Trial | Concept | Badge Awarded |
|---|---|---|---|
| 1 | Chitra-Sandhi | Sliding jigsaw puzzle of heritage imagery | Shreshthi Architect |
| 2 | Akshar-Manthan | Anagram challenge with classical script terms | Vidvan Grammarian |
| 3 | Yugma-Milan | Matching pairs of traditions & artifacts | — |
| 4 | Varga-Karan | Taxonomy sort across heritage domains | — |
| 5 | Drishti-Pariksha | Macro-lens identification of craft details | — |
| 6 | Kala-Kram | Timeline sequencer for historical events | — |
| 7 | Chakra-Virasat | Konark wheel-themed heritage quiz | Kala Chakra Master |
| 8 | Riti-Vandana | Memory matrix for ritual & ceremony | — |
| — | All 8 Trials | Full completion | Virasat Grand Scholar |

---

## 🏗️ Architecture

Three-layer system with a Groq multi-stage fallback chain for zero-downtime AI inference:

```
User Input
   │
   ▼
Frontend (HTML5/CSS3, Web Audio API, Leaflet.js, Web Speech API, Fullscreen API)
   │
   ▼
Backend (Java 17 · Spring Boot 3.3.4 · Hibernate ORM 6.5.3 · Spring Security + JWT)
   │
   ▼
Data & AI (PostgreSQL + HikariCP · Groq: gpt-oss-120b → gpt-oss-20b → qwen3.6-27b)
   │
   ▼
Markdown Response → Frontend Render
```

**Database — 6 core entities:** `User` · `UserBadge` · `HeritageSite` · `Story` · `ChatMessage` · `QuizRecord`

**Key REST endpoints:**
```
GET  /api/heritage/sites
POST /api/stories/generate
POST /api/quiz/submit
```

---

## 🧰 Tech Stack

<p>
  <strong>Backend</strong><br/>
  <img src="https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot_3.3.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Security_+_JWT-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
  <img src="https://img.shields.io/badge/Hibernate_ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white"/>
</p>

<p>
  <strong>Data & AI</strong><br/>
  <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white"/>
  <img src="https://img.shields.io/badge/HikariCP-333333?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Supabase-3FCF8E?style=for-the-badge&logo=supabase&logoColor=white"/>
  <img src="https://img.shields.io/badge/Groq_API-F55036?style=for-the-badge"/>
</p>

<p>
  <strong>Frontend</strong><br/>
  <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white"/>
  <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white"/>
  <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"/>
  <img src="https://img.shields.io/badge/Leaflet.js-199900?style=for-the-badge&logo=leaflet&logoColor=white"/>
</p>

<p>
  <strong>Browser APIs</strong><br/>
  <img src="https://img.shields.io/badge/Web_Audio_API-FF6F00?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Web_Speech_API-4285F4?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Fullscreen_API-333333?style=for-the-badge"/>
</p>

<p>
  <strong>Deployment</strong><br/>
  <img src="https://img.shields.io/badge/Render-46E3B7?style=for-the-badge&logo=render&logoColor=white"/>
  <img src="https://img.shields.io/badge/Vercel-000000?style=for-the-badge&logo=vercel&logoColor=white"/>
  <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"/>
</p>

---

## 🎯 Why VirasatSetu

| Strength | Description |
|---|---|
| 🏆 **Only Unified Platform** | Documentation + teaching + revival in one ecosystem — no Indian precedent |
| 🛡️ **Production-Grade Resilience** | Three-model Groq fallback chain ensures zero-downtime AI inference |
| 🎓 **Youth-First Design** | Gamification + multilingual AI storytelling closes the intergenerational gap |
| 📜 **Policy-Ready** | Ministry of Culture alignment + UNESCO-compatible documentation corpus |

**Stakeholder impact:** Ministry of Culture · Artisans & Practitioners · Educators · Folklorists & Researchers · Youth

---

## 🚀 Live Demo

🔗 **[virasatsetu-phi.vercel.app](https://virasatsetu-phi.vercel.app/)**

**Suggested walkthrough:**
1. **Explore a Domain** — open a case study and review a practitioner profile with geo-coordinates
2. **GIS Map Interaction** — filter by category, click a site marker, watch the camera fly to it
3. **AI Storyteller** — pick a dynasty, theme & tone, generate a narrative, and hear it via voice synthesis
4. **Cultural Gaming Trial** — play Chitra-Sandhi and watch the XP/badge system update live

---

## 👤 Author

**Shiv Pramod Koli**
[GitHub](https://github.com/shivkoli07) · [LinkedIn](https://linkedin.com/in/shiv-koli-42516b355)

<div align="center">
<i>The window to capture living heritage is closing. VirasatSetu acts now — before the last masters are gone.</i>
</div>
